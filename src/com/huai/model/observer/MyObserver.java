package com.huai.model.observer;

/**
 * Created by liangyh on 16-1-1.
 */
public interface MyObserver {
    void update(MyObservable myObservable, Object arg);
}
