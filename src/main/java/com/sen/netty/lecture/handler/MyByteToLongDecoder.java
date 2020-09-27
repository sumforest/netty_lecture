package com.sen.netty.lecture.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author sen
 * @date 2020/9/27 23:55
 * @description
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode in active");
        // long类型为8个字节
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
