package com.sen.decorator;

/**
 * @author sen
 * @date 2020/7/19 16:25
 * @description 具体构建角色
 */
public class ConcreteComponent  implements Component{

    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
