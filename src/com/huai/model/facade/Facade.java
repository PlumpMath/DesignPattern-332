package com.huai.model.facade;

/**
 * 门面类
 *
 * Created by liangyh on 15-12-31.
 */
public class Facade {
    private Payment payment;
    private Cook cook;
    private Waiter waiter;

    public Facade(){
        this.payment = new Payment();
        this.cook = new Cook();
        this.waiter = new Waiter();
    }

    public Facade(Payment payment, Cook cook, Waiter waiter){
        this.payment = payment;
        this.cook = cook;
        this.waiter = waiter;
    }

    public void doServe(){
        payment.doPay();
        cook.doCook();
        waiter.doServe();
    }
}
