package com.huai.model.test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by liangyh on 16-1-6.
 */
public class MainTest {
    public static void main(String args[]){
        Component component = new ConcreteComponent();
        ConcreteDecorator decorator = new ConcreteDecorator(component);
        decorator.doSomething();
    }
}

interface Component{
    void doSomething();
}

class ConcreteComponent implements Component{

    @Override
    public void doSomething(){
        System.out.println("do some thing");
    }
}

abstract class Decorator implements Component{
    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}


class ConcreteDecorator extends Decorator{
    private Component component;

    public ConcreteDecorator(Component component){
        super(component);
        this.component = component;
    }

    @Override
    public void doSomething() {
        before();
        component.doSomething();
        after();
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}