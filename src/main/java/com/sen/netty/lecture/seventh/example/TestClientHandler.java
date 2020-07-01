package com.sen.netty.lecture.seventh.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author sen
 * @date 2020/6/28 23:27
 * @description
 */
public class TestClientHandler extends SimpleChannelInboundHandler<TransferMultiMessage.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TransferMultiMessage.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomNum = new Random().nextInt(3);
        TransferMultiMessage.MyMessage myMessage = null;
        if (1 == randomNum) {
            myMessage = TransferMultiMessage
                    .MyMessage
                    .newBuilder()
                    .setDateType(TransferMultiMessage.MyMessage.DataType.StudentType)
                    .setStudent(
                            TransferMultiMessage.Student.newBuilder()
                            .setName("张三")
                            .setAge(20)
                            .setAddresses("广州")
                            .build())
                    .build();
        }else if(2 == randomNum){
            myMessage = TransferMultiMessage
                    .MyMessage
                    .newBuilder()
                    .setDateType(TransferMultiMessage.MyMessage.DataType.DogType)
                    .setDog(
                            TransferMultiMessage
                                    .Dog
                                    .newBuilder()
                                    .setName("哈士奇")
                                    .setWeight(50).build())
                    .build();
        }else{
            myMessage = TransferMultiMessage
                    .MyMessage
                    .newBuilder()
                    .setDateType(TransferMultiMessage.MyMessage.DataType.CatType)
                    .setCat(
                            TransferMultiMessage
                            .Cat
                            .newBuilder()
                            .setName("喵喵")
                            .setColor("彩虹色")
                            .build())
                    .build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
