package com.sen.decorator;

/**
 * @author sen
 * @date 2020/7/19 16:32
 * @description
 */
public class Client {

    public static void main(String[] args) {
        new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent())).doSomething();
    }
}
