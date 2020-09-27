package com.sen.netty.lecture.bytebuf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author sen
 * @date 2020/9/27 15:21
 * @description
 */
public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        Person person = new Person();

        // for (int i = 0; i < 10; i++) {
        //     new Thread(()->{
        //         try {
        //             TimeUnit.MICROSECONDS.sleep(1);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         System.out.println(person.age++);
        //     }).start();
        // }

        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class
                , "age");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            }).start();
        }
    }

    private static class Person {
        volatile int age = 1;
    }
}
