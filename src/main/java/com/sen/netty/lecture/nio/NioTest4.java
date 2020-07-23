package com.sen.netty.lecture.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sen
 * @date 2020/7/23 00:13
 * @description
 */
public class NioTest4 {

    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            // 重置buff
            // 注释此方法将会造成死循环
            // 第一次读取文件调用flip()方法后，再写出文件后position == limit导致再次读取的时候读不到东西，read=0
            byteBuffer.clear();
            int read = inputChannel.read(byteBuffer);
            System.out.println("read:" + read);
            if (read == -1) {
                break;
            }
            // 翻转
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        inputChannel.close();
        outputChannel.close();
    }
}
