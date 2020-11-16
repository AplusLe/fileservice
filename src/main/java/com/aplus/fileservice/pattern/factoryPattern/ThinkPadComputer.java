package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 18:36
 */

/**
 *  继承台式机父类,实际的ThinkPad台式电脑产品类
 */
public class ThinkPadComputer extends Computer {
    @Override
    protected void makeComputer() {
        System.out.println("制造了一台ThinkPad台式电脑");
    }
}
