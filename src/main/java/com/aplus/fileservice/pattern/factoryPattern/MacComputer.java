package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 18:38
 */


/**
 *  继承台式机父类,实际的Mac台式电脑产品类
 */
public class MacComputer extends Computer {
    @Override
    protected void makeComputer() {
        System.out.println("制造一台Mac台式电脑");
    }
}
