package com.huai.model.proxy.cgLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liangyh on 15-12-24.
 */
public class CgLibTest{
    public static void main(String[] args) {
        CgLibProxy proxy = new CgLibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Boss.class);
        enhancer.setCallback(proxy);
        Boss boss = (Boss)enhancer.create();

        boss.doSomething();
    }

}

class Boss{
    public void doSomething(){
        System.out.println("do something");
    }
}

class CgLibProxy implements  MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
