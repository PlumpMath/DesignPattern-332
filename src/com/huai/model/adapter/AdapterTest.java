package com.huai.model.adapter;

/**
 * Created by liangyh on 16-1-2.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable targetable = new Adpater();
        targetable.method1();
        targetable.method2();
    }
}

class Source{
    public void method1(){
        System.out.println("method 1");
    }
}

interface Targetable{
    //这个方法和Source类所定义的方法一样。
    public void method1();

    public void method2();
}

class Adpater extends Source implements Targetable{
    //Source类中的method1方法，相当于Targetable接口method1的实现方法。

    public void method2(){
        System.out.println("this is the targetable method");
    }
}
