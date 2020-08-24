package com.sen.netty.lecture.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author sen
 * @date 2020/8/24 23:29
 * @description Java字符集编码
 */
public class NioTest13 {

    public static void main(String[] args) throws Exception{
        File inputFile = new File("NioTest13_input.txt");
        File outputFile = new File("NioTest13_output.txt");

        RandomAccessFile inputAccessFile = new RandomAccessFile(inputFile,"r");
        RandomAccessFile outputAccessFile = new RandomAccessFile(outputFile,"rw");

        FileChannel inputChannel = inputAccessFile.getChannel();
        FileChannel outputChannel = outputAccessFile.getChannel();

        // 内存映射文件
        MappedByteBuffer inputData = inputChannel.map(FileChannel.MapMode.READ_ONLY,0,inputAccessFile.length());

        // 获取字符集对象
        Charset charset = StandardCharsets.UTF_8;
        // 获取解码对象
        CharsetDecoder charsetDecoder = charset.newDecoder();
        // 获取编码对象
        CharsetEncoder charsetEncoder = charset.newEncoder();

        CharBuffer charBuffer = charsetDecoder.decode(inputData);
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);

        outputChannel.write(byteBuffer);

        inputAccessFile.close();
        outputAccessFile.close();
    }
}
