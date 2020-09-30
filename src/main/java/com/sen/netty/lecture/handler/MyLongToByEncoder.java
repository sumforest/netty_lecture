package com.sen.netty.lecture.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author sen
 * @date 2020/10/1 01:07
 * @description 自定义编码器
 */
public class MyLongToByEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked!");
        System.out.println("msg: " +  msg);
        out.writeLong(msg);
    }
}
