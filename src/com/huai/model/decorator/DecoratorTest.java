package com.huai.model.decorator;

/**
 * Created by liangyh on 16-1-3.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecorator decorator = new ConcreteDecorator(component);
        decorator.doSomething();
    }
}

interface Component{
    public void doSomething();
}

class ConcreteComponent implements Component{

    @Override
    public void doSomething() {
        System.out.println("component do something");
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

    public ConcreteDecorator(Component component){
        super(component);
    }

    @Override
    public void doSomething() {
        doOtherThing();
        super.doSomething();
    }

    public void doOtherThing(){
        System.out.println("do other thing");
    }
}


















