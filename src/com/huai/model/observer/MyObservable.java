package com.huai.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * Created by liangyh on 16-1-1.
 */
public abstract class MyObservable {

    private List<MyObserver> observerList;

    public MyObservable(){
        this.observerList = new ArrayList<>();
    }

    public void addObserver(MyObserver observer){
        if(observer == null) throw new NullPointerException();

        observerList.add(observer);
    }

    public void notifyAllObserver(Object value){
        if(this.observerList == null || observerList.size() == 0) return;

        for(int i = 0; i < observerList.size(); i++){
            observerList.get(i).update(this,value);
        }
    }
}
