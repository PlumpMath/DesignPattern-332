package com.huai.model.proxy.stati;

/**
 * Created by liangyh on 15-12-23.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Proxy p = new Proxy(manager);
        p.doBusiness();
    }
}

interface Business{
    public void doBusiness();
}

class Manager implements Business{
    @Override
    public void doBusiness() {
        System.out.println("manager do business");
    }
}

class Boss implements Business{
    @Override
    public void doBusiness() {
        System.out.println("boss do business");
    }
}

class Proxy implements Business{

    private Business business;

    public Proxy(){
    }

    public Proxy(Business business){
        this.business = business;
    }

    @Override
    public void doBusiness() {
        Log.log();
        before();
        this.business.doBusiness();
        after();
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