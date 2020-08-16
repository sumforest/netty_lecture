package com.sen.netty.lecture.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sen
 * @date 2020/8/16 17:30
 * @description {@link java.nio.channels.Selector}
 */
public class NioTest12 {

    public static void main(String[] args) throws Exception{
        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++) {
            // 获取channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 配置channel为异步
            serverSocketChannel.configureBlocking(false);
            // 获取socket
            ServerSocket socket = serverSocketChannel.socket();
            // 绑定端口号
            InetSocketAddress inetSocketAddress = new InetSocketAddress(ports[i]);
            socket.bind(inetSocketAddress);

            // 把通道注册到选择器,并且监听连接接受事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口：" + ports[i]);
        }

        // 单线程死循环监听处理多个连接
        while(true){
            // 获取可操作的channel数量
            int number = selector.select();
            System.out.println("number: " + number);

            // 获取selectionKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys: " + selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()){
                    // 获取channel
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    // 获取连接
                    SocketChannel socketChannel = channel.accept();
                    // 设置为异步
                    socketChannel.configureBlocking(false);
                    // 重新注册监听状态为可读
                    socketChannel.register(selector,SelectionKey.OP_READ);

                    // 删除已经处理的selectionKeys
                    iterator.remove();
                    System.out.println("获得客户端连接： " + socketChannel);
                } else if (selectionKey.isReadable()) {
                    // 获取通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    int readBytes = 0;
                    while(true){
                        // 读取客户端内容
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = channel.read(byteBuffer);
                        if (read <=0){
                            break;
                        }
                        byteBuffer.flip();
                        // 往客户端写回接收到的内容
                        channel.write(byteBuffer);
                        readBytes += read;
                    }

                    iterator.remove();
                    System.out.println("读取：" + readBytes + "，来自客户端：" + channel);
                }
            }
        }
    }
}
