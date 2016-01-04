package com.huai.model.proxy.dyanamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liangyh on 15-12-23.
 */
public class DynamicProxyTest {
    public static void main(String args[]){

        Boss boss = new Boss();

        Business business = (Business)Proxy.newProxyInstance(boss.getClass().getClassLoader(),
                new Class[]{Business.class}, new ProxyHandler(boss));

        business.doBusiness();
    }
}

interface Business{
    public void doBusiness();
}

class Boss implements Business{
    @Override
    public void doBusiness() {
        System.out.println("boss do business");
    }
}

class ProxyHandler implements InvocationHandler{
    private Object obj = null;

    private ProxyHandler(){

    }

    public ProxyHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Log.log();
        before();
        result = method.invoke(obj, args);
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

class Log{
    public static void log(){
        System.out.println("log");
    }
}


