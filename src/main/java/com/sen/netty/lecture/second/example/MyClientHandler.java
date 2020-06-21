package com.sen.netty.lecture.second.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @author sen
 * @date 2020/6/21
 * @description 自定义客户端处理逻辑
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 输出服务端地址，消息
        System.out.println("address: " + ctx.channel().remoteAddress() + ", msg: " + msg);
        // 响应消息给服务端
        ctx.writeAndFlush("from client: " + LocalDateTime.now());
    }

    /**
     * 通道连接后回调此方法
     * @param ctx 通道上下文
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("channelActive: 来自客户端亲切的问候");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
