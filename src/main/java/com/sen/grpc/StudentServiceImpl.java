package com.sen.grpc;

import com.sen.proto.MyRequest;
import com.sen.proto.MyResponse;
import com.sen.proto.StudentRequest;
import com.sen.proto.StudentResponse;
import com.sen.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author sen
 * @date 2020/7/12 16:29
 * @description GRPC定义service实现
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

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
}
