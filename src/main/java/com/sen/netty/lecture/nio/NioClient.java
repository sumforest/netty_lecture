package com.sen.netty.lecture.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sen
 * @date 2020/8/22 00:24
 * @description Nio网络客户端
 */
public class NioClient {

    public static void main(String[] args) throws Exception {
        // 获取客户端channel
        SocketChannel socketChannel = SocketChannel.open();
        // 设置成异步
        socketChannel.configureBlocking(false);

        // 获取选择器
        Selector selector = Selector.open();
        // 注册通道到选择器，并且监听连接事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // 连接服务器
        socketChannel.connect(new InetSocketAddress("localhost", 8899));

        while (true) {
            // 获取所关注的并且已经触发的事件
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                try {
                    if (selectionKey.isConnectable()) {
                        // 客户端连接服务端
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if (client.isConnectionPending()) {
                            // 连接服务器的客户单通道处于正在连接的状态，建立连接
                            client.finishConnect();

                            // 想服务端发送客户单一连接的消息
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            byteBuffer.put((LocalDateTime.now() + " 连接建立").getBytes());
                            byteBuffer.flip();
                            client.write(byteBuffer);

                            // 启用一个新的线程获取键盘的标准输入
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                try {
                                    byteBuffer.clear();
                                    InputStreamReader reader = new InputStreamReader(System.in);
                                    BufferedReader bufferedReader = new BufferedReader(reader);

                                    String message = bufferedReader.readLine();
                                    byteBuffer.put(message.getBytes());
                                    byteBuffer.flip();
                                    client.write(byteBuffer);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
