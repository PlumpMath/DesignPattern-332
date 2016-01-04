package com.huai.model.observer;

/**
 * 被观察者
 * Created by liangyh on 16-1-1.
 */
public class House extends MyObservable{
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyAllObserver("通知每一个观察者，现在的价格为："+price);
    }
}
