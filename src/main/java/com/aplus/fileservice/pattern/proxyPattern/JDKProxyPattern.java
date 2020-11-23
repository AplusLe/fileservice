package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 19:38
 */

/**
 * JDK动态代理模式
 * 动态代理也叫做:JDK代理,接口代理 要求目标对象是实现一个接口的目标对象
 * 优点：代理对象,不需要实现接口 减少系统复杂性
 * 缺点： 目标对象一定要实现接口,否则不能用动态代理
 */
public class JDKProxyPattern {
    public static void main(String[] args) {
        ProxyFactory proxy = new ProxyFactory(new RealImage("付费图"));
        // 生成动态代理对象
         Image image = (Image)proxy.getProxyFactoryInstance();
        image.display();
    }
}
