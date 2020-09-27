package com.sen.netty.lecture.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author sen
 * @date 2020/9/27 23:51
 * @description
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //添加自定义解码器
        pipeline.addLast(null);
        // 添加自定义处理器
        pipeline.addLast(new MyServerHandler());
    }
}
