package com.sen.netty.lecture.nio;

import java.nio.ByteBuffer;

/**
 * @author sen
 * @date 2020/7/23 23:59
 * @description 只读buffer，一个读写buff可以随时转换成只读buffer；但是一个只读buffer不能转换成读写buffer
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.getClass());

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.put((byte) 1);
    }
}
