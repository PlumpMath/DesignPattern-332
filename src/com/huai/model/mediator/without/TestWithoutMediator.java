package com.huai.model.mediator.without;

/**
 * 不使用中介模式的情况
 * <p>A类设置数字的时候会改变B类的数字，反之也是</p>
 * Created by liangyh on 16-1-12.
 */
public class TestWithoutMediator {
    public static void main(String[] args) {
        Num a = new A();
        Num b = new B();
        a.setNumber(4, b);
        int bNum = b.getNumber();
        System.out.println(bNum);
    }
}

abstract class Num{
    private int a ;

    public Num(){}

    public Num(int number){
        this.a = number;
    }

    public int getNumber(){
        return this.a;
    }

    protected void setNumber(int number){
        this.a = number;
    }

    abstract void setNumber(int number, Num num);
}

class A extends Num{

    public A(){}

    public A(int a){
        super(a);
    }

    @Override
    public void setNumber(int number, Num num) {
        num.setNumber(number*1000);
    }
}

class B extends Num{

    public B(){}

    public B(int a){
        super(a);
    }

    @Override
    void setNumber(int number, Num num) {
        num.setNumber(number/1000);
    }
}
