package com.sen.netty.lecture.handler3;

/**
 * @author sen
 * @date 2020/10/5 15:28
 * @description 自定义协议对象
 */
public class MyPersonProto {

    private int length;

    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
