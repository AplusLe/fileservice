package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 20:06
 */

/**
 * Cglib 动态代理
 *
 * 目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理
 *
 */
public class CglibProxyPattern {


    public static void main(String[] args) {
        IndependentImage image = new IndependentImage("精品独立图");
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(image);
        IndependentImage image2  = (IndependentImage)cglibProxyFactory.getProxyInstance();
        image2.display();
    }
}
