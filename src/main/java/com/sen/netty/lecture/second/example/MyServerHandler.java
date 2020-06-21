package com.sen.netty.lecture.second.example;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author sen
 * @date 2020/6/20
 * @description 自定义处理逻辑handler
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 读取消息时被调用
     * @param ctx 通道上下文
     * @param msg 消息
     * @throws Exception e
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 输出远程地址-->客户端地址
        System.out.println("address: "+ctx.channel().remoteAddress()+", msg: " + msg);
        // 想客户端相应uuid
        ctx.writeAndFlush("fromServer: " + UUID.randomUUID().toString());
    }

    /**
     * 异常处理
     * @param ctx 通道上下文
     * @param cause 被捕获异常
     * @throws Exception 手动抛出异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 打印异常
        cause.printStackTrace();
        // 关闭连接
        ctx.close();
    }
}
