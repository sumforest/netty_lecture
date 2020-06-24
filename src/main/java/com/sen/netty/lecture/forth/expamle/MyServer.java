package com.sen.netty.lecture.forth.expamle;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author sen
 * @date 2020/6/24
 * @description netty空闲状态检测 读空闲，写空闲，读写空闲;启动第三个例子客户端测试
 */
public class MyServer {

    public static void main(String[] args) throws Exception{
        // 处理连接线程事件组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理连接内容事件组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 设定bossGroup的处理器
                    .childHandler(new LoggingHandler(LogLevel.INFO))
                    // 设定workerGroup的处理器
                    .childHandler(new MyServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
