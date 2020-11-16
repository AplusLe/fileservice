package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 19:42
 */
public class ThinkPadLaptop extends Laptop {

    @Override
    protected void makeLaptop() {
        System.out.println("制造了一台ThinkPad笔记本电脑");
    }
}
