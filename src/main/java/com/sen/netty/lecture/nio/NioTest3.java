package com.sen.netty.lecture.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sen
 * @date 2020/7/21 22:24
 * @description
 */
public class NioTest3 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        byte[] data = "hello world Nio".getBytes();

        for (byte datum : data) {
            buffer.put(datum);
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
        fileOutputStream.close();
    }
}
