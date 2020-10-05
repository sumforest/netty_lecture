package com.sen.netty.lecture.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author sen
 * @date 2020/10/5 11:26
 * @description
 */
public class MyLongToStringDecoder extends MessageToMessageDecoder<Long> {

    @Override
    protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
        System.out.println("MyLongToStringDecoder decoder invoked!");
        out.add(String.valueOf(msg));
    }
}
