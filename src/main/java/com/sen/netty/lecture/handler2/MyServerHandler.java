package com.sen.netty.lecture.handler2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @author sen
 * @date 2020/10/5 12:18
 * @description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] content = new byte[msg.readableBytes()];
        msg.readBytes(content);
        System.out.println("服务端接收到的消息：" + new String(content, CharsetUtil.UTF_8));
        System.out.println("服务端接收到的消息数量： " + ++count);
        ctx.writeAndFlush(Unpooled.copiedBuffer(UUID.randomUUID().toString(),CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
