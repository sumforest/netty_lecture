package com.sen.protobuf;

/**
 * @author sen
 * @date 2020/6/26 22:30
 * @description protobuf序列化工具测试
 */
public class ProtoBufTest {

    public static void main(String[] args) throws Exception{
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(22)
                .setAddress("广东广州")
                .build();

        // 序列化成字节数组
        byte[] bytes = student.toByteArray();

        // 由字节数字反序列化成对象
        DataInfo.Student studentParse=  DataInfo.Student.parseFrom(bytes);

        System.out.println(studentParse.toString());
        System.out.println(studentParse.getName());
        System.out.println(studentParse.getAge());
        System.out.println(studentParse.getAddress());
    }
}
