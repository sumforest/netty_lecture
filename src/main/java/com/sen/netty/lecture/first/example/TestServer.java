package com.sen.netty.lecture.first.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author sen
 * @date 2020/6/17
 * @description netty第一个例子
 */
public class TestServer {

    public static void main(String[] args) throws Exception{
        // 定义接收请求线程组（死循环），事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 定义工作线程成组（死循环），事件循环组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 定义netty启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 设置线程组到启动类中
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 添加子处理器（相当于拦截器）
                    .childHandler(new TestServerInitializer());

            // 同步绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            // 监听关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            // 优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
