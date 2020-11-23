package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 19:59
 */

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  Cglib 代理工厂
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object target;

    public CglibProxyFactory() {}

    public CglibProxyFactory(Object independentImage) {
        this.target = independentImage;
    }

    // 目标对象创建一个代理对象  会默认调用代理对象无参的构造方法，如果父类没有默认构造方法会抛出
    // java.lang.IllegalArgumentException: Superclass has no null constructors but no arguments were given
    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("独立支付...");
        return invoke;
    }
}
