package com.huai.model.bridge;

/**
 * 这个类是两个维度之中的一个维度，这个维度会持有另一个维度的引用，另一个维度是Sweet
 * Created by liangyh on 15-12-31.
 */
public class BeerNoodle extends AbtractNoodle{

    public BeerNoodle(Sweet style){
        super(style);
    }

    @Override
    void eat() {
        System.out.println("beer noodle");
        super.getStyle().style();
    }
}
