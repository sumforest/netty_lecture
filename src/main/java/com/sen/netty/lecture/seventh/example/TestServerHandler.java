package com.sen.netty.lecture.seventh.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author sen
 * @date 2020/6/28 23:17
 * @description
 */
public class TestServerHandler extends SimpleChannelInboundHandler<TransferMultiMessage.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TransferMultiMessage.MyMessage msg) throws Exception {
        if (TransferMultiMessage.MyMessage.DataType.StudentType == msg.getDateType()) {
            TransferMultiMessage.Student student = msg.getStudent();
            // 输出消息信息
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddresses());
        }else if(TransferMultiMessage.MyMessage.DataType.DogType == msg.getDateType()){
            TransferMultiMessage.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getWeight());
        }else{
            TransferMultiMessage.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getColor());
        }

    }
}
