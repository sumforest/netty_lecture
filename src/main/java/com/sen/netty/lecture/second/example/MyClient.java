package com.sen.netty.lecture.second.example;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author sen
 * @date 2020/6/20
 * @description socker客户端
 */
public class MyClient {

    public static void main(String[] args) throws Exception {
        // 创建一个事件循环组，因为只需要连接不需要处理连接
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            // 创建客户端启动累
            Bootstrap bootstrap = new Bootstrap();
            // 绑定事件循环组
            bootstrap.group(eventLoopGroup)
                    // 设定channel类型
                    .channel(NioSocketChannel.class)
                    // 设定事件循环组的初始化器
                    .handler(new MyClientInitializer());
            // 连接服务器
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            // 监听关闭事件
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
