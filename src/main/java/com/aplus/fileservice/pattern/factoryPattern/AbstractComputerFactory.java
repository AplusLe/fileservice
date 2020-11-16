package com.aplus.fileservice.pattern.factoryPattern;

/**
 * 工厂方法模式
 * 优点：
 * 工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。
 * 添加新产品时，只需要添加对应工厂，无需修改其他软件对象 符合开闭原则
 * 缺点：
 * 添加新产品时，不仅需要实现新产品类也要添加对应的产品工厂
 *
 *
 * 进化
 * 抽象工厂模式
 * 每个具体工厂能创建多种对象，就从工厂方法模式转化成为抽象工厂模式
 * 由抽象工厂规定每种具体工厂的产品
 * 优点：
 * 所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例
 * ，就可以在某种程度上改变整个软件系统的行为 强内聚，松耦合
 * 增加具体工厂和开辟产品族 符合开闭原则
 *
 * 缺点：
 * 难以增加非原有产品族的新产品 不仅完成产品本身的抽象和具体实现，涉及到对抽象工厂角色及其所有子类的修改
 * 开闭原则发生倾斜
 * 增加新的产品等级结构：对于增加新的产品等级结构，需要修改所有的工厂角色，包括抽象工厂类
 * ，在所有的工厂类中都需要增加生产新产品的方法，违背了“开闭原则”
 */
public abstract class AbstractComputerFactory {

    protected abstract Computer createComputer();
    protected abstract Laptop createLaptop();

    public static void main(String[] args) {
        ThinkPadComputerFactory thinkPadComputerFactory = new ThinkPadComputerFactory();
        Computer computer = thinkPadComputerFactory.createComputer();
        Laptop laptop = thinkPadComputerFactory.createLaptop();
        computer.makeComputer();
        laptop.makeLaptop();

        MacComputerFactory macComputerFactory = new MacComputerFactory();
        Computer computer1 = macComputerFactory.createComputer();
        Laptop laptop1 = macComputerFactory.createLaptop();
        computer1.makeComputer();
        laptop1.makeLaptop();
    }
}
