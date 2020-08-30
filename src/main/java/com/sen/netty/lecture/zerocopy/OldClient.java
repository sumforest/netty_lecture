package com.sen.netty.lecture.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @author sen
 * @date 2020/8/30 17:41
 * @description 传统IO客户端
 */
public class OldClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);

        String fileName = "/Users/sen/Desktop/VMware-Fusion-11.5.5-16269456.dmg";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buff = new byte[4096];
        int read;
        int total = 0;

        long start = System.currentTimeMillis();

        while ((read = fileInputStream.read(buff)) >= 0) {
            total += read;
            dataOutputStream.write(buff,0,read);
        }
        System.out.println("本次传输大小：" + total + "，耗费时间："+ (System.currentTimeMillis()  - start));
        dataOutputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
