package com.huai.model.observer;

/**
 * 观察者1
 * Created by liangyh on 16-1-1.
 */
public class Observer2 implements MyObserver{
    @Override
    public void update(MyObservable myObservable, Object arg) {
        System.out.println("observer2 : "+arg);
    }
}
