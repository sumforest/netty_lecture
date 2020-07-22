package com.sen.decorator;

/**
 * @author sen
 * @date 2020/7/19 16:28
 * @description 具体装饰着1
 */
public class ConcreteDecorator1 extends Decorator implements Component{


    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("功能B");
    }
}
