package com.sen.netty.lecture.handler3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author sen
 * @date 2020/10/5 15:56
 * @description
 */
public class MyClient {

    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MyPersonDecoder())
                                .addLast(new MyPerSonEncoder())
                                .addLast(new MyClientHandler());
                    }
                });

        try {
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }
}
