package com.aplus.fileservice.pattern.singletonPattern;

/**
 *  单例模式的最佳实现方式
 *
 *  简洁，自动支持序列化机制，绝对防止多次实例化,抗住反射
 */
public enum  EnumSingleton {
    INSTANCE;
    public void whateverMethod() {

    }

}
