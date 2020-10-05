package com.sen.netty.lecture.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author sen
 * @date 2020/10/5 10:54
 * @description 基于 {@link ReplayingDecoder}实现自定义解码器
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 invoked!");
        out.add(in.readLong());
    }
}
