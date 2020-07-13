package com.sen.grpc;

import com.sen.proto.MyRequest;
import com.sen.proto.MyResponse;
import com.sen.proto.StreamRequest;
import com.sen.proto.StreamResponse;
import com.sen.proto.StudentList;
import com.sen.proto.StudentRequest;
import com.sen.proto.StudentResponse;
import com.sen.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author sen
 * @date 2020/7/12 16:50
 * @description GRPC客户端
 */
public class StudentGrpcClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext()
                .build();
        StudentServiceGrpc.StudentServiceBlockingStub stub = StudentServiceGrpc.newBlockingStub(channel);
        MyResponse response = stub.getRealNameByUsername(MyRequest.newBuilder().setUsername("Charles").build());
        System.out.println("rpc调用结果：" + response.getRealname());

        System.out.println("----------- 客户端发送一个对象，服务端响应stream -----------");

        Iterator<StudentResponse> streamIterator = stub.getUsersByAge(StudentRequest.newBuilder().setAge(22).build());
        while (streamIterator.hasNext()) {
            StudentResponse streamResponse = streamIterator.next();
            System.out.println(streamResponse.getUsername() + ", " + streamResponse.getAge() + ", " + streamResponse.getCity());
        }

        System.out.println("----------- 客户端发送一个流式对象，服务端响应一个对象 -----------");
        // 构建一个异步的桩
        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(channel);
        // 构建一个发送流式数据后回调处理服务端数据的Observer
        StreamObserver<StudentList> studentListStreamObserver = new StreamObserver<StudentList>() {
            /**
             *  接受到服务端数据后被回调
             * @param value
             */
            @Override
            public void onNext(StudentList value) {
                System.out.println("客户端发送一个流式对象，接收到服务端响应：");
                value.getListList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getUsername());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("***********************");
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        };
        StreamObserver<StudentRequest> streamObserver = studentServiceStub.getUsersByAges(studentListStreamObserver);
        streamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        streamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        streamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        streamObserver.onCompleted();
        // 因为异步所以不会等待客户端返回所以需要阻塞主线程
        TimeUnit.SECONDS.sleep(5);

        System.out.println("----- 客户端发送一个流式数据，服务端返回一个流式数据 ----");
        StreamObserver<StreamResponse> streamObserverResponse = new StreamObserver<StreamResponse>() {
            /**
             * 接收到服务器响应回调
             * @param value
             */
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("接收到服务器响应" + value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        };
        StreamObserver<StreamRequest> streamRequestStreamObserver = studentServiceStub.biTack(
                streamObserverResponse);
        for (int i = 0; i < 10; i++) {
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
        }
        streamRequestStreamObserver.onCompleted();
        // 因为异步所以不会等待客户端返回所以需要阻塞主线程
        TimeUnit.SECONDS.sleep(5);
    }
}
