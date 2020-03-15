package io.grpc.implementation;

import grpc.averagecomputation.v1.averageRequest;
import grpc.averagecomputation.v1.averageResponse;
import grpc.averagecomputation.v1.averageServiceGrpc;
import io.grpc.stub.StreamObserver;

public class AverageServiceImpl extends averageServiceGrpc.averageServiceImplBase{
    @Override
    public StreamObserver<averageRequest> computeAverage(StreamObserver<averageResponse> responseObserver) {

        StreamObserver<averageRequest> streamObserver= new StreamObserver<averageRequest>() {
            int sum=0;
            int count=0;
            double res=0.00;
            @Override
            public void onNext(averageRequest value) {
                sum+=value.getNum();
                count+=1;
            }
            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
            res=(double)sum/(double)count;
            responseObserver.onNext(averageResponse.newBuilder().setResult(res).build());
            responseObserver.onCompleted();
            }
        };
        return streamObserver;
    }
}
