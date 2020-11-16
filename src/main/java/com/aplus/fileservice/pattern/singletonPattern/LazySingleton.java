package com.aplus.fileservice.pattern.singletonPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/12 19:18
 */

/**
 *  懒汉式单例模式，在需要使用时时加载
 *  优点: 在实例被需要时，实例化。 提升了性能
 *  缺点: 在多线程环境下，程序并非串行执行，在最优先级线程A执行至实例化时，其他线程执行判空 会实例化多个实例
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;
    // 私有构造方法
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton =  new LazySingleton();
        }
        return lazySingleton;
    }
}
