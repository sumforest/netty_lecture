package com.sen.netty.lecture.third.example;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sen
 * @date 2020/6/24
 * @description 群聊客户端
 */
public class MyChatClient {

    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            // 启动客户端服务器
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatHandlerInitializer());
            // 启动
            Channel channel = bootstrap.connect("localhost",8899).sync().channel();

            // 发送消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 循环读取命令行输入
            // 次死循环比while(true)性能更好，没使用寄存器，没跳转指令判断，指令数少
            for (; ; ) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
