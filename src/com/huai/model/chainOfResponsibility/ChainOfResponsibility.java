package com.huai.model.chainOfResponsibility;

/**
 * 什么是链
 *1、链是一系列节点的集合。
 *2.、链的各节点可灵活拆分再重组。
 *
 *职责链模式
 *使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系，
 *将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。
 *
 *角色
 *抽象处理者角色(Handler)：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现。
 *具体处理者角色(ConcreteHandler)：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。
 *抽象处理者角色
 * Created by liangyh on 16-1-13.
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler1 = new HandlerImpl1();
        Handler handler2 = new HandlerImpl2();

        handler1.setNextHandler(handler2);
        handler1.handleRequest();
    }
}

/**
 * 处理抽象类，保存着下一个处理者的引用，同时负责处理请求。
 */
abstract class  Handler{
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler(){
        return this.nextHandler;
    }

    public abstract void handleRequest();
}

/**
 * 具体的处理类
 * 当有下一个处理类时，就把request处理传递下去，否则就自己处理。
 */
class HandlerImpl1 extends Handler{
    @Override
    public void handleRequest() {
        if(this.getNextHandler() == null){
            System.out.println("handle request 1");
        }else{
            this.getNextHandler().handleRequest();
        }
    }
}

class HandlerImpl2 extends Handler{
    @Override
    public void handleRequest() {
        if(this.getNextHandler() == null){
            System.out.println("handle request 2");
        }else{
            this.getNextHandler().handleRequest();
        }
    }
}

