package com.huai.model.bridge;

/**
 * Created by liangyh on 15-12-31.
 */
public class PorkyNoodle extends AbtractNoodle{

    public PorkyNoodle(Sweet style){
        super(style);
    }

    @Override
    void eat() {
        System.out.println("porkey noodle \r\n");
        super.getStyle().style();
    }
}
