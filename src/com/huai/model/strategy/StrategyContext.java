package com.huai.model.strategy;

/**
 * Created by liangyh on 15-12-31.
 */
public class StrategyContext {
    private DiscountStrategy discountStrategy;

    public StrategyContext(){

    }

    public StrategyContext(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy(){
        if(this.discountStrategy == null){
            DiscountStrategy tempD = new OldDiscount();
            this.discountStrategy = tempD;
        }
        return this.discountStrategy;
    }

    public void changeDiscount(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }
}
