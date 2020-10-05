package com.sen.netty.lecture.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author sen
 * @date 2020/10/5 15:35
 * @description
 */
public class MyPerSonEncoder extends MessageToByteEncoder<MyPersonProto> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MyPersonProto msg, ByteBuf out) throws Exception {
        System.out.println("MyPerSonEncoder invoked!");
        int length = msg.getLength();
        byte[] content = msg.getContent();

        out.writeInt(length);
        out.writeBytes(content);
    }
}
