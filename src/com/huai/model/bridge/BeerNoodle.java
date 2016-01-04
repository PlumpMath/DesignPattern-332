package com.huai.model.bridge;

/**
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
