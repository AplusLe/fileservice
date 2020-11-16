package com.aplus.fileservice.pattern.singletonPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/12 19:42
 */

/**
 *  双重检查锁单例模式 double-check locking
 *  在懒汉模式下对实例化加锁 volatile是为了防止指令重排序
 *
 */
public class DclSingleton {
    private static volatile  DclSingleton dclSingleton;
    private DclSingleton (){}

    public DclSingleton getInstance () {
        if (dclSingleton == null) {
            synchronized (DclSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton =  new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
