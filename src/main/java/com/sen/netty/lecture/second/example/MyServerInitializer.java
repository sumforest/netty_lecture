package com.sen.netty.lecture.second.example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author sen
 * @date 2020/6/20
 * @description 服务器初始化器，添加编码器，解码器，handler
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 获取通道管道
        ChannelPipeline pipeline = ch.pipeline();
        //添加编码器
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast(new LengthFieldPrepender(4));
        // 添加字符串解码器
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        // 添加字符串编码器
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        // 添加handler
        pipeline.addLast(new MyServerHandler());
    }
}
