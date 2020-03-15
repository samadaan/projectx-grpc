package io.grpc.services;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.health.v1.HealthCheckResponse;
import io.grpc.implementation.AverageServiceImpl;
import io.grpc.implementation.BookServiceImpl;
import io.grpc.implementation.MaximumServiceImpl;
import io.grpc.implementation.PrimeServiceImpl;
import java.io.IOException;
import java.util.logging.Logger;
public class MainServer
{
    private static final Logger LOGGER = Logger.getLogger(MainServer.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException
    {
        String serviceString1 ="grpc.book.v1.bookService";
        String serviceString2 ="grpc.primefactorisation.v1.primeService";
        String serviceString3 ="grpc.averagecomputation.v1.averageService";
        String serviceString4 ="grpc.findmaximum.v1.maximumService";
     //   String noService = "";
        HealthServiceImpl healthService= new HealthServiceImpl();
        healthService.setStatus(serviceString1, HealthCheckResponse.ServingStatus.SERVING);
        healthService.setStatus(serviceString2,HealthCheckResponse.ServingStatus.SERVING);
        healthService.setStatus(serviceString3,HealthCheckResponse.ServingStatus.SERVING);
        healthService.setStatus(serviceString4,HealthCheckResponse.ServingStatus.SERVING);
        healthService.setStatus(noService,HealthCheckResponse.ServingStatus.NOT_SERVING);
        Server server = ServerBuilder.forPort(50083)
                .addService(healthService)
                .addService(new BookServiceImpl())
                .addService(new PrimeServiceImpl())
                .addService(new AverageServiceImpl())
    //            .addService(new MaximumServiceImpl())
                .build();
        server.start();
        System.out.println("Server Successfully Started");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Server Shutdown Requested");
            server.shutdown();
            System.out.println("Server Shutdown Completed");
        }));
        server.awaitTermination();
    }
}