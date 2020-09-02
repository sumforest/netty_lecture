package com.sen.netty.lecture.source;

import io.netty.channel.EventLoopGroup;
import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * @author sen
 * @date 2020/9/2 23:53
 * @description 获取netty {@link EventLoopGroup} 启动的线程数
 */
public class NioEventLoopGroupTest {

    public static void main(String[] args) {
        int max = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(max);
    }
}
