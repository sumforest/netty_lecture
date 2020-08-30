package com.sen.netty.lecture.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sen
 * @date 2020/8/30 17:34
 * @description 传统IO服务器
 */
public class OldServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] bytes = new byte[4096];
            while (true){
                int read = dataInputStream.read(bytes,0,bytes.length);
                if (read == -1){
                    break;
                }
            }
        }
    }
}
