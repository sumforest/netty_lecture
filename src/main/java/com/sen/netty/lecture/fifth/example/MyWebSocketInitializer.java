package com.sen.netty.lecture.fifth.example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author sen
 * @date 2020/6/25 09:32
 * @description
 */
public class MyWebSocketInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // http请求相应编码器
        pipeline.addLast(new HttpServerCodec())
                // 以块发送数据编码器
                .addLast(new ChunkedWriteHandler())
                // http请求聚合器，把快请求组合成一个完整的Http对象，不会出现一次请求多次处理的情况
                .addLast(new HttpObjectAggregator(4096))
                // netty实现对于websocket协议支持的处理器
                .addLast(new WebSocketServerProtocolHandler("/ws"))
                .addLast(new TextWebSocketFrameHandler());
    }
}
