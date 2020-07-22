package com.sen.netty.lecture.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sen
 * @date 2020/7/19 18:43
 * @description
 */
public class NioTest2 {

    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream  = new FileInputStream("NioTest2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            System.out.println("Chart:"+ (char)byteBuffer.get());
        }
    }
}
