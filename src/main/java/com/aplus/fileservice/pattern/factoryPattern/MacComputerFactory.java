package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 19:25
 */
public class MacComputerFactory extends AbstractComputerFactory {
    @Override
    protected Computer createComputer() {
        return new MacComputer();
    }

    @Override
    protected Laptop createLaptop() {
        return new MacLaptop();
    }
}
