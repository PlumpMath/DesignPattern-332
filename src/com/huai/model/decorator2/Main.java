package com.huai.model.decorator2;

/**
 * Created by liangyh on 16-1-3.
 */
public class Main {
    public static void main(String[] args) {
        //被装饰者
        Component component = new ConcreteComponent();

        //装饰者1
        Decorator decorator1 = new ConcreteDecorator1(component);
        decorator1.doSomething();

        //装饰者2
        Decorator decorator2 = new ConcreteDecorator2(component);
        decorator2.doSomething();
    }
}

/**
 * 被装饰的类的接口
 */
interface Component{
    void doSomething();
}

/**
 * 被装饰的类
 */
class ConcreteComponent implements Component{

    @Override
    public void doSomething(){
        System.out.println("component do some thing");
    }
}

/**
 * 装饰者，抽象类
 */
abstract class Decorator implements Component{
    //持有被装饰者的接口引用
    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void doSomething() {
         this.component.doSomething();
    }
}

/**
 * 装饰者具体实现类1
 */
class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        before();
        super.doSomething();
        after();
    }

    public void before(){
        System.out.println("before1");
    }

    public void after(){
        System.out.println("after1");
    }
}

/**
 * 装饰者具体实现类2
 */
class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        before();
        super.doSomething();
        after();
    }

    public void before(){
        System.out.println("before2");
    }

    public void after(){
        System.out.println("after2");
    }
}