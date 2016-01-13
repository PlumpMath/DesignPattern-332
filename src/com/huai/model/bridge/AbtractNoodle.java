package com.huai.model.bridge;

/**
 * 这个抽象类连接Sweet和noodle这两个维度。起到桥梁的作用.
 * 通过它，可以把Sweet维度的引用传递给noodle维度。
 * Created by liangyh on 15-12-31.
 */
public abstract class AbtractNoodle {
    private Sweet style;

    public AbtractNoodle(Sweet style){
        this.style = style;
    }

    public Sweet getStyle(){
        return this.style;
    }

    abstract void  eat();
}
