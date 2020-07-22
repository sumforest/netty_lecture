package com.sen.netty.lecture.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author sen
 * @date 2020/7/19 17:34
 * @description
 */
public class NioTest1 {

    public static void main(String[] args) {
        /*
         * 创建buff时
         * position 0
         * limit 10
         * capacity 10
         * */
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < 5; i++) {
            int nextInt = new SecureRandom().nextInt(20);
            intBuffer.put(nextInt);
        }

        System.out.println("limit:" + intBuffer.limit());
        System.out.println("position:" + intBuffer.position());

        /*
         * flip()后
         * position 0
         * limit = position(position重置前的位置)
         * capacity = capacity
         * */
        intBuffer.flip();
        System.out.println("enter while loop");
        while (intBuffer.hasRemaining()) {
            System.out.println("limit:" + intBuffer.limit());
            System.out.println("position:" + intBuffer.position());
            System.out.println("capacity:" + intBuffer.capacity());
            System.out.println(intBuffer.get());
        }
    }
}
