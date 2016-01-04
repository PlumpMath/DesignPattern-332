package com.huai.model.strategy;

/**
 * Created by liangyh on 15-12-31.
 */
public class Main {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.getDiscountStrategy().doDiscount(33);

        VipDiscount vipDiscount = new VipDiscount();
        strategyContext.changeDiscount(vipDiscount);

        strategyContext.getDiscountStrategy().doDiscount(20);
    }
}
