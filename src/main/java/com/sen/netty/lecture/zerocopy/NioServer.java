package com.sen.netty.lecture.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author sen
 * @date 2020/8/30 18:14
 * @description NIO服务端
 */
public class NioServer {

    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        // 当绑定当前端口的服务端程序关闭之后会进入超时状态，在超时时间内不能重新绑定别的应用程序；
        // 增加此项设置之后在超时状态的端口可以重新被绑定
        socket.setReuseAddress(true);
        socket.bind(inetSocketAddress);

        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            // socketChannel一定是阻塞的,此项配置多余
            socketChannel.configureBlocking(true);
            ByteBuffer buffer  = ByteBuffer.allocate(4096);

            int readCount = 0;
            while (readCount != -1) {
                readCount = socketChannel.read(buffer);
                // 充值buffer
                buffer.rewind();
            }
        }
    }
}
