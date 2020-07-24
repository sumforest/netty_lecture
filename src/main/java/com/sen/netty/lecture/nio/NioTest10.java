package com.sen.netty.lecture.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author sen
 * @date 2020/7/24 23:30
 * @description 给MappedByteBuff加锁
 */
public class NioTest10 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        // 加锁起始位置，结束位置，true为读共享锁，false为排他锁
        FileLock fileLock = channel.lock(0, 3, true);
        System.out.println("isValid: " + fileLock.isValid());
        System.out.println("isShared: " + fileLock.isShared());

        fileLock.release();
        channel.close();
    }
}
