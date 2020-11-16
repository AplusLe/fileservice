package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 19:44
 */
public class MacLaptop extends Laptop {
    @Override
    protected void makeLaptop() {
        System.out.println("制造了一台Mac笔记本电脑");
    }
}
