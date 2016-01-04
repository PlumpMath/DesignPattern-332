package com.huai.model.strategy;

/**
 * Created by liangyh on 15-12-31.
 */
public class OldDiscount implements DiscountStrategy{
    @Override
    public void doDiscount(int count) {
        System.out.println("old discount");
    }
}
