package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 18:41
 */
public class AsusComputer extends Computer {
    @Override
    protected void makeComputer() {
        System.out.println("制造了一台ASUS电脑");
    }
}
