package com.sen.netty.lecture.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.stream.Stream;

/**
 * @author sen
 * @date 2020/7/26 16:21
 * @description Scatting（分散） 和 gathering（采集）
 */
public class NioTest11 {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 定义消息长度
        int messageLength = 2 + 3 + 4;

        ByteBuffer[] byteBuffers = new ByteBuffer[3];

        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        System.out.println("初始化服务器完毕");

        // 开启监听
        SocketChannel socketChannel = serverSocketChannel.accept();

        //业务逻辑代码
        while (true) {
            int readLength = 0;
            while (readLength < messageLength) {
                // 读取buffer数组
                long read = socketChannel.read(byteBuffers);
                readLength += read;
                System.out.println("read: " + read);
                Stream.of(byteBuffers)
                        .map(byteBuffer -> "position: " + byteBuffer.position() + "; " + "limit: " + byteBuffer.limit())
                        .forEach(System.out::println);
            }

            Stream.of(byteBuffers).forEach(Buffer::flip);

            int writeLength = 0;
            while (writeLength < messageLength) {
                // 响应内容给客户端
                long write = socketChannel.write(byteBuffers);
                writeLength +=write;
                System.out.println("write: "+write);
            }

            Stream.of(byteBuffers).forEach(ByteBuffer::clear);
            System.out.println("readLength: " + readLength + " ;writeLength: " + writeLength);
        }
    }
}
