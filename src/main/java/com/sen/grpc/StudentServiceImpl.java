package com.sen.grpc;


import com.sen.proto.MyRequest;
import com.sen.proto.MyResponse;
import com.sen.proto.StreamRequest;
import com.sen.proto.StreamResponse;
import com.sen.proto.StudentList;
import com.sen.proto.StudentRequest;
import com.sen.proto.StudentResponse;
import com.sen.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * @author sen
 * @date 2020/7/12 16:29
 * @description GRPC定义service实现
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    /**
     * GRPC数据格式1：客户端发送一个参数，服务端返回一个参数
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.printf("服务段被调用,收到参数：%s\n", request.getUsername());
        // 使用StreamObserver响应客户端请求
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        // 给stream响应已经完成
        responseObserver.onCompleted();
    }

    /**
     * 实现客户端发送一个对象服务端响应一个stream对象
     * 实质：stream对象对应的Java上是一个对应类型的迭代器
     *
     * @param request          请求对象，GRPC中请求对象必须是message不能是int32/string等基本数据类型
     * @param responseObserver 用于响应个客户端的数据
     */
    @Override
    public void getUsersByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端请求stream数据的请求，参数：" + request.toString());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setUsername("张三")
                .setAge(request.getAge())
                .setCity("北京")
                .build()
        );
        responseObserver.onNext(StudentResponse.newBuilder()
                .setUsername("李四")
                .setAge(request.getAge())
                .setCity("上海")
                .build()
        );
        responseObserver.onNext(StudentResponse.newBuilder()
                .setUsername("王五")
                .setAge(request.getAge())
                .setCity("广州")
                .build()
        );
        responseObserver.onNext(StudentResponse.newBuilder()
                .setUsername("赵六")
                .setAge(request.getAge())
                .setCity("广州")
                .build()
        );
        // 通知stream操作结束
        responseObserver.onCompleted();
    }

    /**
     * 客户端发送一个流式数据，服务端返回一个对象
     *
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<StudentRequest> getUsersByAges(StreamObserver<StudentList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            /**
             * 服务端接收到客户端的数据时被回调
             * @param value
             */
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("服务端接收到客户端的流式数据：" + value);
            }

            /**
             * 发生异常时被回调
             * @param t
             */
            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            /**
             * 客户端链接完成流式数据传输时被回调，用于响应一个对象给客户端
             */
            @Override
            public void onCompleted() {
                responseObserver.onNext(
                        StudentList.newBuilder()
                                .addList(StudentResponse.newBuilder().setUsername("张三").setAge(22).setCity("深圳").build())
                                .addList(StudentResponse.newBuilder().setUsername("李四").setAge(24).setCity("深圳").build())
                                .build()
                );
                // 结束本次操作
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * 客户端发送一个流式数据，服务端返回一个流式数据
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<StreamRequest> biTack(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("客户端发送一个流式数据，服务端返回一个流式数据;接收客户端参数: "+value.getRequestInfo());
                // 接收到参数的同时响应数据给服务端
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                // 当客户端完成时，服务端也完成
                responseObserver.onCompleted();
            }
        };
    }
}
