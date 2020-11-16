package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 19:20
 */
public class ThinkPadComputerFactory extends AbstractComputerFactory{
    @Override
    protected Computer createComputer() {
        return new ThinkPadComputer();
    }

    @Override
    protected Laptop createLaptop() {
        return new ThinkPadLaptop();
    }
}
