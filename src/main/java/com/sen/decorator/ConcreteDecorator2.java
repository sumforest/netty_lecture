package com.sen.decorator;

/**
 * @author sen
 * @date 2020/7/19 16:31
 * @description
 */
public class ConcreteDecorator2 extends Decorator implements Component{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("功能C");
    }
}
