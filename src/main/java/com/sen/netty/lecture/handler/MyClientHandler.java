package com.sen.netty.lecture.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author sen
 * @date 2020/9/28 00:05
 * @description
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("from server: " + msg);
        ctx.writeAndFlush(654321L);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // ctx.writeAndFlush(654321L);
        // ctx.writeAndFlush(1L);
        // ctx.writeAndFlush(2L);
        // ctx.writeAndFlush(3L);
        // ctx.writeAndFlush(4L);
        ctx.writeAndFlush(Unpooled.copiedBuffer("helloworld", CharsetUtil.UTF_8));
    }
}
