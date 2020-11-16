package com.aplus.fileservice.pattern.factoryPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 18:31
 */

/**
 * 简单工厂：
 *  优点：
 * 实现对模块的解耦 提供专门的工厂类用于创建对象，使得客户端只关注对象的使用
 * 缺点：
 * 如果新增需要创建的对象，就不得不修改工厂方法，违反开闭原则 < 软件对象（类、模块、方法等）应该对于扩展是开放的
 * ，对修改是关闭的>
 * 创建对象集中于工厂方法，容错率低
 * 增加系统中类的个数，增加系统复杂性
 */


// 简单工厂类
public class ComputerFactory {
    // 静态方法有时可以更有作用
    public Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "ThinkPad" : computer = new ThinkPadComputer();
            break;
            case "Mac" : computer = new MacComputer();
            break;
            default: computer = new AsusComputer();
        }
        return  computer;
    }

    // 简单工厂测试
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer thinkPad = computerFactory.createComputer("ThinkPad");
        thinkPad.makeComputer();
    }
}
