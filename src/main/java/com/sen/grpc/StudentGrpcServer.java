package com.sen.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author sen
 * @date 2020/7/12 16:35
 * @description GRPC服务端
 */
public class StudentGrpcServer {

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(8899)
                .addService(new StudentServiceImpl())
                .build()
                .start();
        System.out.println("服务端已经启动");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JVM即将关闭");
        }));
        System.out.println("JVM关闭钩子函数已经添加");
    }

    private void stop(){
        if (this.server != null) {
            server.shutdown();
        }
    }

    private void await() throws InterruptedException {
        if (this.server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudentGrpcServer server = new StudentGrpcServer();
        server.start();
        server.await();
    }
}
