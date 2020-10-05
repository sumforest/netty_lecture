package com.sen.netty.lecture.handler2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author sen
 * @date 2020/10/5 12:28
 * @description
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("send msg from client!",CharsetUtil.UTF_8));
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] content = new byte[msg.readableBytes()];
        msg.readBytes(content);
        System.out.println("客户端接收到消息： " + new String(content, CharsetUtil.UTF_8));
        System.out.println("客户读接收到消息数量： " + ++count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
