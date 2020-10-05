package com.sen.netty.lecture.handler3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author sen
 * @date 2020/10/5 15:53
 * @description
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyPersonDecoder());
        pipeline.addLast(new MyPerSonEncoder());
        pipeline.addLast(new MyServerHandler());
    }
}
