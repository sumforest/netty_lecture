package com.sen.grpc;

import com.sen.proto.MyRequest;
import com.sen.proto.MyResponse;
import com.sen.proto.StudentRequest;
import com.sen.proto.StudentResponse;
import com.sen.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * @author sen
 * @date 2020/7/12 16:50
 * @description GRPC客户端
 */
public class StudentGrpcClient {

    public static void main(String[] args) {
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
    }
}
