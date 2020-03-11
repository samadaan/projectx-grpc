package io.grpc.implementation;

import grpc.primefactorisation.v1.primeNumRequest;
import grpc.primefactorisation.v1.primeNumResponse;
import grpc.primefactorisation.v1.primeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PrimeServiceImpl extends primeServiceGrpc.primeServiceImplBase{
    private static final Logger LOGGER = Logger.getLogger(PrimeServiceImpl.class.getName());
    @Override
    public void primeDecomposition(primeNumRequest request, StreamObserver<primeNumResponse> responseObserver) {
        int a = request.getPrime();
        int x=2;
        try{
        while(a!=1)
        {
            if(a%x==0)
            {
                a/=x;
                primeNumResponse numResponse= primeNumResponse.newBuilder().setPrimeResult(x).build();
                responseObserver.onNext(numResponse);
                Thread.sleep(1000L);
            }
            else{
                x++;
            }
        }
    }
        catch(InterruptedException e)
        {
            LOGGER.info(e.toString());
        }
        finally {
            responseObserver.onCompleted();
        }
        }
}
