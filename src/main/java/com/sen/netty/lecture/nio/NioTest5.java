package com.sen.netty.lecture.nio;

import java.nio.ByteBuffer;

/**
 * @author sen
 * @date 2020/7/23 23:23
 * @description 实用put()方法写入基本数据类型，用get()方法获取基本数据类型，放入和拿去类型的顺序要统一
 */
public class NioTest5 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(123);
        buffer.putChar('A');
        buffer.putDouble(3.1415926);
        buffer.putLong(1234567L);
        buffer.putShort((short) 1);
        buffer.putChar('E');

        // 翻转
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getChar());
    }
}
