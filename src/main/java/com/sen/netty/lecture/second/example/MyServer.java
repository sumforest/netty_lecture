package com.sen.netty.lecture.second.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author sen
 * @date 2020/6/20
 * @description socket服务器
 */
public class MyServer {

    public static void main(String[] args) throws Exception{
        // 创建两个时件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建启动器
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 添加事件循环组
            serverBootstrap.group(bossGroup, workerGroup)
                    // 设定服务器通道类型
                    .channel(NioServerSocketChannel.class)
                    // 添加子处理器childHandler-->对应workerGroup，还可以添加handler-->对应的是bossGroup的处理逻辑
                    .childHandler(new MyServerInitializer());
            // 绑定端口号,最后的sync()方法表示一直循环监听8899端口
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            // 监听等待事件
            channelFuture.channel().closeFuture().sync();
        }finally {
            // 优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
