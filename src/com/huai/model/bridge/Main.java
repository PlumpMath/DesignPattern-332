package com.huai.model.bridge;

/**
 * Created by liangyh on 15-12-31.
 */
public class Main {
    public static void main(String[] args) {
        //sweet维度
        Sweet plainStyle = new PlainStyle();
        //noodle维度
        PorkyNoodle porkyNoodle = new PorkyNoodle(plainStyle);

        porkyNoodle.eat();
    }


}
