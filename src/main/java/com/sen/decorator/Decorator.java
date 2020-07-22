package com.sen.decorator;

/**
 * @author sen
 * @date 2020/7/19 16:26
 * @description 装饰者角色
 */
public class Decorator implements Component{

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }


    @Override
    public void doSomething() {
        this.component.doSomething();
    }
}
