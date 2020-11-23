package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 18:27
 */

/**
 * 静态代理模式
 * 优点： 1、职责清晰。 2、高扩展性。 3、智能化。
 * 缺点：1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
 *  2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂
 *
 * 需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 * 不修改目标对象的功能前提下,对目标功能扩展
 */
public class StaticProxyPatten {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("巨图");
        // 图片需要加载
        image.display();

        // 图片不需要加载
        image.display();
    }
}
