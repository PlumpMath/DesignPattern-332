package com.huai.model.observer;

/**
 * Created by liangyh on 16-1-1.
 */
public class Main {
    public static void main(String[] args) {
        House house = new House();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        house.addObserver(observer1);
        house.addObserver(observer2);

        house.setPrice(20);

    }
}
