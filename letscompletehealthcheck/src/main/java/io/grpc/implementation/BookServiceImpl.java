package io.grpc.implementation;
import grpc.book.v1.bookServiceGrpc;
import grpc.book.v1.getBookByIdRequest;
import grpc.book.v1.getBookByIdResponse;
import io.grpc.stub.StreamObserver;
public class BookServiceImpl extends bookServiceGrpc.bookServiceImplBase{
    @Override
    public void getBookById(getBookByIdRequest request, StreamObserver<getBookByIdResponse> responseObserver) {
        int bookId= request.getId();
        getBookByIdResponse bookByIdResponse1= getBookByIdResponse.newBuilder().setId(1).setName("Sherlock Holmes").setDescription("This is the best Detective Book").build();
        getBookByIdResponse bookByIdResponse2= getBookByIdResponse.newBuilder().setId(2).setName("Three Mistakes of my life").setDescription("A masterpiece by Chetan Bhagat").build();
        getBookByIdResponse bookByIdResponse3= getBookByIdResponse.newBuilder().setId(3).setName("Lets See it out").setDescription("Must check for all").build();
        getBookByIdResponse bookByIdResponse4= getBookByIdResponse.newBuilder().setId(4).setName("Life is just coming").setDescription("Experience life to its fullest").build();
        getBookByIdResponse bookByIdResponse5= getBookByIdResponse.newBuilder().setId(5).setName("Its Now or Never").setDescription("Understanding time is Important").build();
        try {
            if (bookId == 1) {
                responseObserver.onNext(bookByIdResponse1);
            } else if (bookId == 2) {
                responseObserver.onNext(bookByIdResponse1);
            } else if (bookId == 3) {
                responseObserver.onNext(bookByIdResponse1);
            } else if (bookId == 4) {
                responseObserver.onNext(bookByIdResponse1);
            } else {
                responseObserver.onNext(bookByIdResponse1);
            }
        }
        finally {
            responseObserver.onCompleted();
        }
    }
}