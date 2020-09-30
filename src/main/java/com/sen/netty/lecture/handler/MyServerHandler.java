package com.sen.netty.lecture.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author sen
 * @date 2020/9/27 23:52
 * @description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("from client: " + msg);
        // ctx.channel().writeAndFlush(123456L);
    }
}
