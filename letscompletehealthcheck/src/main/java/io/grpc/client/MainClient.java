package io.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.health.v1.HealthCheckRequest;
import io.grpc.health.v1.HealthCheckResponse;
import io.grpc.health.v1.HealthGrpc;

public class MainClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",50083).usePlaintext().build();
        HealthGrpc.HealthBlockingStub healthBlockingStub= HealthGrpc.newBlockingStub(managedChannel);
        HealthCheckRequest healthCheckRequest1= HealthCheckRequest.newBuilder().setService("grpc.book.v1.bookService").build();
        HealthCheckRequest healthCheckRequest2= HealthCheckRequest.newBuilder().setService("grpc.primefactorisation.v1.primeService").build();
        HealthCheckRequest healthCheckRequest3= HealthCheckRequest.newBuilder().setService("grpc.averagecomputation.v1.averageService").build();
        HealthCheckRequest healthCheckRequest4= HealthCheckRequest.newBuilder().setService("grpc.findmaximum.v1.maximumService").build();
        HealthCheckRequest healthCheckRequest5= HealthCheckRequest.newBuilder().setService("").build();
        HealthCheckResponse healthCheckResponse1=healthBlockingStub.check(healthCheckRequest1);
        HealthCheckResponse healthCheckResponse2=healthBlockingStub.check(healthCheckRequest2);
        HealthCheckResponse healthCheckResponse3=healthBlockingStub.check(healthCheckRequest3);
        HealthCheckResponse healthCheckResponse4=healthBlockingStub.check(healthCheckRequest4);
        HealthCheckResponse healthCheckResponse5=healthBlockingStub.check(healthCheckRequest5);
        System.out.println("Successfully set service");
        System.out.println(healthCheckResponse1.getStatus());
        System.out.println(healthCheckResponse2.getStatus());
        System.out.println(healthCheckResponse3.getStatus());
        System.out.println(healthCheckResponse4.getStatus());
        System.out.println(healthCheckResponse5.getStatus());
    }
}
