package com.sen.netty.lecture.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sen
 * @date 2020/7/24 23:13
 * @description 内存映射文件（位于堆外内存） {@link java.nio.MappedByteBuffer} 修改位于内存中的数据然后操作系统自动把修改后的数据写入到文件
 * 当中
 */
public class NioTest9 {

    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("NioTest9.txt","rw");
        // 获取通道，调用map方法把文件映射到堆外内存
        MappedByteBuffer mappedByteBuffer = accessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 5);

        // 修改文件
        mappedByteBuffer.put(0, (byte) 'e');
        mappedByteBuffer.put(3, (byte) 'A');

        accessFile.close();
    }
}
