package com.sen.netty.lecture.third.example;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author sen
 * @date 2020/6/23
 * @description
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * netty提供的存放并管理channel的集合，当channel断开与服务器连接时netty会自动移除该channel
     */
    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 接收消息时被调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch->{
            if (ch != channel) {
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息：" + msg + "\n");
            }else {
                ch.writeAndFlush("[自己]" + msg + "\n");
            }
        });
    }

    /**
     * 客户端链接服务端时回调
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 向已连接的客户端发送消息，有新的客户端加入
        channelGroup.writeAndFlush("[服务器] " + channel.remoteAddress() + " 加入\n");
        // 把当前客户端的channel加入到通道组中
        channelGroup.add(channel);
    }

    /**
     * 客户段断开连接时回调
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] " + channel.remoteAddress() + " 离开\n");
    }

    /**
     * 通道活跃时回调
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线");
    }

    /**
     * 捕获异常处理回调
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
