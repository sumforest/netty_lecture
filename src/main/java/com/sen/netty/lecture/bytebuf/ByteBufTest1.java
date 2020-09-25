package com.sen.netty.lecture.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author sen
 * @date 2020/9/26 00:27
 * @description
 */
public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);

        // 相对方法，会改变readerIndex和writerIndex
        for (int i = 0; i < byteBuf.capacity(); i++) {
            byteBuf.writeByte(i);
        }

        // 绝对方法，不会该表readerIndex和writerIndex
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }
    }
}
