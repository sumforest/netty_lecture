package com.sen.netty.lecture.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @author sen
 * @date 2020/10/5 15:38
 * @description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyPersonProto> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyPersonProto msg) throws Exception {
        System.out.println("接收到消息长度： " + msg.getLength());
        System.out.println("接收到消息的内容： " + new String(msg.getContent(), CharsetUtil.UTF_8));
        System.out.println("接收到消息的数量：" + ++count);

        String resp = UUID.randomUUID().toString();
        int length = resp.length();
        byte[] content = resp.getBytes(CharsetUtil.US_ASCII);
        ctx.writeAndFlush(new MyPersonProto(){{
            setLength(length);
            setContent(content);
        }});
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
