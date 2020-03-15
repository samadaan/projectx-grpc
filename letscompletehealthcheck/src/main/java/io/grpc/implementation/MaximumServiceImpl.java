package io.grpc.implementation;

import grpc.findmaximum.v1.maximumRequest;
import grpc.findmaximum.v1.maximumResponse;
import grpc.findmaximum.v1.maximumServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class MaximumServiceImpl extends maximumServiceGrpc.maximumServiceImplBase{
    private static final Logger LOGGER = Logger.getLogger(MaximumServiceImpl.class.getName());
    @Override
    public StreamObserver<maximumRequest> findMaximum(StreamObserver<maximumResponse> responseObserver) {

        StreamObserver<maximumRequest> maximumRequestStreamObserver= new StreamObserver<maximumRequest>() {
            int max=-99999;
            @Override
            public void onNext(maximumRequest value) {
                LOGGER.info("Fetching the new maximum....");
                LOGGER.info("The new maximum is");
                if(max<value.getNumber())
                    max=value.getNumber();
                responseObserver.onNext(maximumResponse.newBuilder().setNumber(max).build());
            }
            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                LOGGER.info("The process has completed");
                responseObserver.onCompleted();
            }
        };
        return maximumRequestStreamObserver;
    }
}
