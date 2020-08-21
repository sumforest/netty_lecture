package com.sen.netty.lecture.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author sen
 * @date 2020/8/21 22:45
 * @description Nio网络服务端
 */
public class NioServer {

    /**
     * 用于推送消息给所有已连接的客户端
     */
    private static final Map<String, SocketChannel> SOCKET_CHANNEL_MAP = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // 定义服务器channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置成异步
        serverSocketChannel.configureBlocking(false);
        // 获取ServerSocket
        ServerSocket socket = serverSocketChannel.socket();
        // 绑定端口号
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        socket.bind(inetSocketAddress);

        // 创建选择器
        Selector selector = Selector.open();
        // 把serverSocketChannel对象注册到选择器,并且监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 阻塞监听注册事件是否发生，发生将返回对应的SelectionKey
            selector.select();
            // 获取selectionKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            // 遍历selectionKeys
            selectionKeys.forEach(selectionKey -> {
                try {
                    final SocketChannel client;
                    // 判断selectionKey的状态
                    if (selectionKey.isAcceptable()) {
                        // 服务端接受到来自客户端的连接
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        // 获取socketChannel

                        client = server.accept();
                        // 设置成异步
                        client.configureBlocking(false);
                        // 把socketChannel注册到选择器，监听可读事件
                        client.register(selector, SelectionKey.OP_READ);

                        // 把连接存起来
                        String key = "[" + UUID.randomUUID().toString() + "]";
                        SOCKET_CHANNEL_MAP.put(key, client);
                        System.out.println("服务器收到新的客户端连接：" + client);

                    } else if (selectionKey.isReadable()) {
                        // socketChannel可读状态
                        client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int readerCount = client.read(byteBuffer);
                        if (readerCount > 0) {
                            // 翻转
                            byteBuffer.flip();
                            // 设置字符集
                            Charset charset = StandardCharsets.UTF_8;
                            String message = String.valueOf(charset.decode(byteBuffer).array());
                            System.out.println(client + ":" + message);
                            // 获取发送消息key
                            String sendMessageKey = null;
                            for (Map.Entry<String, SocketChannel> entry : SOCKET_CHANNEL_MAP.entrySet()) {
                                if (entry.getValue() == client) {
                                    sendMessageKey = entry.getKey();
                                }
                            }

                            // 发送消息给所有连接的客户端
                            String finalSendMessageKey = sendMessageKey;
                            SOCKET_CHANNEL_MAP.forEach((k, v) -> {
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                buffer.put((finalSendMessageKey + ":" + message).getBytes());
                                // 翻转
                                buffer.flip();
                                try {
                                    v.write(buffer);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            // 清空集合
            selectionKeys.clear();
        }
    }
}
