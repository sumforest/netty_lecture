package com.sen.netty.lecture.first.example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author sen
 * @date 2020/6/18
 * @description 通道初始化器
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 只要客户端与服务端一链接就会调用此方法
     * @param ch SocketChannel
     * @throws Exception 异常
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 获取管道流
        ChannelPipeline pipeline = ch.pipeline();
        // 给管道流添加拦截器,注意是非单例模式，每次都要new一个对象
        // 涉及到Http通讯的一定要HttpServerCodec,HttpServerCodec是HttpRequestDecoder和HttpResponseEncoder的统一
        pipeline.addLast("httpServerCodec", new HttpServerCodec())
                .addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
