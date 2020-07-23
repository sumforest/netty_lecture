package com.sen.netty.lecture.nio;

import java.nio.ByteBuffer;

/**
 * @author sen
 * @date 2020/7/23 23:31
 * @description 使用 {@link ByteBuffer#slice()}实现部分buff浅拷贝
 */
public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        // 设定limit position
        buffer.limit(6);
        buffer.position(2);

        // 左闭右开
        ByteBuffer sliceBuffer = buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            sliceBuffer.put((byte) (sliceBuffer.get(i)*2));
        }

        // 重置buff
        buffer.clear();
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get(i));
        }
    }
}
