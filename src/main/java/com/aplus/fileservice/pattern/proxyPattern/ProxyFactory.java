package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 19:26
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  动态代理工厂
 */
public class ProxyFactory {
    // 目标对象
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyFactoryInstance () {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces()
                , (Object o, Method method, Object[] objects) -> {
                Object invoke = method.invoke(target, objects);
                System.out.println("支付加载费用...");
                return invoke;
            });
    }
}
