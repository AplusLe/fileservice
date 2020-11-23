package com.aplus.fileservice.pattern.singletonPattern;

/**
 * 使用静态内部类，构造的单例模式
 *
 * 外部类初次加载，会初始化静态变量、静态代码块、静态方法，但不会加载内部类和静态内部类。
 * 实例化外部类，调用外部类的静态方法、静态变量，则外部类必须先进行加载，但只加载一次。
 * 直接调用静态内部类时，外部类不会加载。
 */
public class InnerSingleton {
    // 私有构造方法

    private InnerSingleton() {};

    // 静态内部类
    private static class SingletonHolder {
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static final  InnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
