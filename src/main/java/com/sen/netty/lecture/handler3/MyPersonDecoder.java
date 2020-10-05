package com.sen.netty.lecture.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author sen
 * @date 2020/10/5 15:30
 * @description
 */
public class MyPersonDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyPersonDecoder invoked!");
        int length = in.readInt();
        byte[] content = new byte[length];
        ByteBuf byteBuf = in.readBytes(length);
        byteBuf.readBytes(content);

        MyPersonProto myPersonProto = new MyPersonProto();
        myPersonProto.setLength(length);
        myPersonProto.setContent(content);
        out.add(myPersonProto);
    }
}
