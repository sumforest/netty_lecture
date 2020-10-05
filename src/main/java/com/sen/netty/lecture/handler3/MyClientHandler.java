package com.sen.netty.lecture.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author sen
 * @date 2020/10/5 15:44
 * @description
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MyPersonProto> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(new MyPersonProto(){{
                String content = "sent from Client";
                setLength(content.getBytes(CharsetUtil.UTF_8).length);
                setContent(content.getBytes(CharsetUtil.UTF_8));
            }});
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyPersonProto msg) throws Exception {
        System.out.println("客户端接收消息长度： " + msg.getLength());
        System.out.println("客户端接收消息内容： " + new String(msg.getContent(), CharsetUtil.UTF_8));
        System.out.println("客户端接收消息的数量： " + ++count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
