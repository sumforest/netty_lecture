package com.sen.netty.lecture.forth.expamle;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author sen
 * @date 2020/6/24 23:39
 * @description
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * {@link IdleStateHandler} 触发空闲状态检查回调它的下一个处理器的
     * {@link ChannelInboundHandlerAdapter#userEventTriggered(ChannelHandlerContext, Object)}方法，也就是当前方法
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 当前对象是事件监听对象
        if (evt instanceof IdleStateEvent) {
            String eventType = null;
            IdleStateEvent idleStateEvent = (IdleStateEvent)evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读或写空闲";
                            break;
                default:
                    break;
            }
            Channel channel = ctx.channel();
            System.out.println(channel.remoteAddress() + " 状态：" + eventType);
            // 把当前连接断开
            channel.close();
        }
    }
}
