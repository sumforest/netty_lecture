package com.sen.netty.lecture.first.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author sen
 * @date 2020/6/18
 * @description 自定义处理逻辑
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取消息，发送消息都会调用此方法
     * @param ctx 通道上下文
     * @param msg 读取到的消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.printf("address: %s\n",ctx.channel().remoteAddress());
        System.out.println(msg.getClass());
        // 阻塞当前线程查看端口连接情况
        TimeUnit.SECONDS.sleep(10);
        if (msg instanceof HttpRequest) {
            HttpRequest request  = (HttpRequest)msg;
            System.out.printf("method: %s\n",request.method().name());
            if ("/favicon.ico".equals(request.uri())) {
                System.out.println("favicon.cio请求，不处理！");
                // 关闭链接
                ctx.channel().close();
                return;
            }
            // 定义返回内容
            ByteBuf content = Unpooled.copiedBuffer("Hello world", CharsetUtil.UTF_8);
            // 定义返回对象
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            // 设置响应头,字符串响应头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            // 设置相应内容长度
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 响应给客户端,调用write方法不会把相应立即返回给客户端，会写入缓冲区
            ctx.writeAndFlush(response);
            // 关闭链接
            ctx.channel().close();
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelUnregistered");
        super.channelUnregistered(ctx);
    }
}
