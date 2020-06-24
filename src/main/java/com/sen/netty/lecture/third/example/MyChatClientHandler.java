package com.sen.netty.lecture.third.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author sen
 * @date 2020/6/24
 * @description 群聊客户段处理器
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {


    /**
     * 接收到服务器消息时被调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 收到服务发送的消息直接输出控制台
        System.out.println(msg);
    }
}
