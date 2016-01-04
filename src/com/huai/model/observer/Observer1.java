package com.huai.model.observer;

/**
 * 观察者2
 * Created by liangyh on 16-1-1.
 */
public class Observer1 implements MyObserver{
    @Override
    public void update(MyObservable myObservable, Object arg) {
        System.out.println("observer1 : "+(String)arg);
    }
}
