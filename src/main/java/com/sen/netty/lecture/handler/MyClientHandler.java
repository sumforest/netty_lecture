package com.sen.netty.lecture.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author sen
 * @date 2020/9/28 00:05
 * @description
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("from server: " + msg);
        // ctx.writeAndFlush(123456L);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(123456L);
        // ctx.writeAndFlush(1L);
        // ctx.writeAndFlush(2L);
        // ctx.writeAndFlush(3L);
        // ctx.writeAndFlush(4L);
        // ctx.writeAndFlush(Unpooled.copiedBuffer("helloworld", CharsetUtil.UTF_8));
    }
}
