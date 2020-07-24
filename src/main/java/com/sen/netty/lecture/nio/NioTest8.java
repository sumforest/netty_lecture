package com.sen.netty.lecture.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sen
 * @date 2020/7/24 22:54
 * @description 直接缓冲区
 */
public class NioTest8 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer directBuff = ByteBuffer.allocateDirect(64);

        while (true) {
            // 重置buffer
            directBuff.clear();
            int read = inputChannel.read(directBuff);
            System.out.println("read:" + read);
            if (read == -1) {
                break;
            }
            // 翻转
            directBuff.flip();
            outputChannel.write(directBuff);
        }

    }
}
