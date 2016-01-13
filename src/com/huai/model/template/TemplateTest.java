package com.huai.model.template;

/**
 * 模版模式
 *又叫模板方法模式，在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情冴下，重新定义算法中的某些步骤。
 * Created by liangyh on 16-1-13.
 */
public class TemplateTest {
    public static void main(String[] args) {
        Drink tea = new Tea();
        tea.make();

        System.out.println("----------------------");

        Drink coffee = new Coffee();
        coffee.make();
    }
}

abstract class Drink{
    /**
     * 冲泡咖啡或茶...流程
     */
    public final void make(){
        boilWater();//把水煮沸
        brew();//用沸水冲泡...
        pourInCup();//把...倒进杯子
        if(hook()){
            addCoundiments();//加...
        }
    }

    public void boilWater(){
        System.out.println("boil water");
    }

    public abstract void brew();

    public void pourInCup(){
        System.out.println("倒进杯子");
    }

    public abstract void addCoundiments();

    public boolean hook(){
        return true;
    }
}

class Tea extends Drink{
    @Override
    public void brew() {
        System.out.println("tea brew");
    }

    @Override
    public void addCoundiments() {
        System.out.println("tea add coundiments");
    }
}

class Coffee extends Drink{
    @Override
    public void brew() {
        System.out.println("coffee brew");
    }

    @Override
    public void addCoundiments() {
        System.out.println("coffee add coundiments");
    }

    @Override
    public boolean hook() {
        return false;
    }
}