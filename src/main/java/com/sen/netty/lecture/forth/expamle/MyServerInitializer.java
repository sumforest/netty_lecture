package com.sen.netty.lecture.forth.expamle;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author sen
 * @date 2020/6/24 23:36
 * @description
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 设置空闲状态处理器
        pipeline.addLast(new IdleStateHandler(5,7,3))
                .addLast(new MyServerHandler());

    }
}
