package com.sen.netty.lecture.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @author sen
 * @date 2020/9/26 23:26
 * @description
 */
public class ByteBufTest2 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("张hello world", CharsetUtil.UTF_8);

        // 若是堆上分配内存的
        if (byteBuf.hasArray()) {
            // 获取字节数组
            byte[] array = byteBuf.array();
            System.out.println(new String(array, CharsetUtil.UTF_8));
            System.out.println(byteBuf);

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());
            System.out.println(byteBuf.readableBytes());

            for (int i = 0; i < byteBuf.readableBytes(); i++) {
                System.out.println((char)byteBuf.getByte(i));
            }

            System.out.println(byteBuf.getCharSequence(0,4,CharsetUtil.UTF_8));
            System.out.println(byteBuf.getCharSequence(4,6,CharsetUtil.UTF_8));
        }
    }
}
