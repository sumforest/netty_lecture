package com.sen.netty.lecture.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author sen
 * @date 2020/8/30 18:40
 * @description NIO客户端
 */
public class NioClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8899);
        socketChannel.connect(inetSocketAddress);
        // 设置为同步可以读取更多的字节
        socketChannel.configureBlocking(true);

        String fileName = "/Users/sen/Desktop/VMware-Fusion-11.5.5-16269456.dmg";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long start = System.currentTimeMillis();
        // 进行零拷贝写入
        long total = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("传输大小：" + total + ",耗费时间：" + (System.currentTimeMillis() - start));
    }
}
