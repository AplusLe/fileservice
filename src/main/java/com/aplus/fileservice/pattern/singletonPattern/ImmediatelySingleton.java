package com.aplus.fileservice.pattern.singletonPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/12 19:17
 */

/**
 * 饿汉式单例模式,单例会直接初始化
 *  优点: 单例在程序启动时就会初始化，即使是多线程环境下，也不会出现异常，造成多个加载多个实例
 *  缺点：如果没有使用该实例，会造成浪费
 */
public class ImmediatelySingleton {

    // 程序加载时初始化
    private static ImmediatelySingleton immediatelySingleton = new ImmediatelySingleton();

    private ImmediatelySingleton(){}

    public static ImmediatelySingleton getInstance() {
        return immediatelySingleton;
    }
}
