package com.huai.model.mediator.with;

/**
 * <p>定义
 * 用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，
 * 从而使耦合松散，而且可以独立地改变它们之间的交互。</p>
 *
 * <p>角色
 *抽象中介者：定义好同事类对象到中介者对象的接口，用于各个同事类之间的通信。
 *一般包括一个或几个抽象的事件方法，并由子类去实现。
 *中介者实现类：从抽象中介者继承而来，实现抽象中介者中定义的事件方法。
 *从一个同事类接收消息，然后通过消息影响其他同时类。
 *同事类：如果一个对象会影响其他的对象，同时也会被其他对象影响，那么这两个对象称为同事类。
 *在类图中，同事类只有一个，这其实是现实的省略，在实际应用中，同事类一般由多个组成，他们之间相互影响，相互依赖。
 *同事类越多，关系越复杂。并且，同事类也可以表现为继承了同一个抽象类的一组实现组成。
 *在中介者模式中，同事类之间必须通过中介者才能进行消息传递。</p>

 *<p>适用情况
 *一般来说，同事类之间的关系是比较复杂的，多个同事类之间互相关联时，
 * 他们之间的关系会呈现为复杂的网状结构，这是一种过度耦合的架构，即不利于类的复用，也不稳定。
 *，假如对象1发生变化，会有4个对象受到影响。
 *如果对象2发生变化，那么会有5个对象受到影响。
 * 也就是说，同事类之间直接关联的设计是不好的。
 *如果引入中介者模式，那么同事类之间的关系将变为星型结构，任何一个类的变动，
 * 只会影响的类本身，以及中介者，这样就减小了系统的耦合。一个好的设计，
 * ，而是使用一个专门的类来管理那些不属于自己的行为。</p>
 *
 * <p>总结
 *
 *在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。
 * 一个类同时依赖多个类的情况也相当普遍，既然存在这样的情况，说明，一对多的依赖关系有它的合理性，
 * 适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，则可能会带来反的效果。
 * 一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。
 * 可以将网状结构变为星状结构，使同事类之间的关系变的清晰一些。
 *
 *中介者模式是一种比较常用的模式，也是一种比较容易被滥用的模式。对于大多数的情况，
 * 同事类之间的关系不会复杂到混乱不堪的网状结构，因此，大多数情况下，
 * 将对象间的依赖关系封装的同事类内部就可以的，没有必要非引入中介者模式。滥用中介者模式，
 * 只会让事情变的更复杂。</p>
 *
 * Created by liangyh on 16-1-12.
 */
public class TestWithMediator {
    public static void main(String[] args) {
        Num a = new A();
        Num b = new B();

        AbstractMediator mediator = new Mediator(a, b);
        a.setNum(1,mediator);

        System.out.println("b = "+b.getNum());

        b.setNum(2000, mediator);
        System.out.println("a = "+a.getNum());
    }
}

abstract class Num{
    private int num ;

    public Num(){}

    public Num(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }
    protected void setNum(int num){
        this.num = num;
    }

    public abstract void setNum(int number, AbstractMediator mediator);
}

abstract class AbstractMediator{
    public Num a;
    public Num b;

    public AbstractMediator(Num a, Num b){
        this.a = a;
        this.b = b;
    }

    abstract void changeA();

    abstract void changeB();
}

class Mediator extends AbstractMediator{

    public Mediator(Num a, Num b){
        super(a, b);
    }

    @Override
    void changeA() {
        super.a.setNum(super.b.getNum()/1000);
    }

    @Override
    void changeB() {
        super.b.setNum(super.a.getNum()*1000);
    }
}

class A extends Num{

    @Override
    public void setNum(int number, AbstractMediator mediator) {
        super.setNum(number);
        mediator.changeB();
    }
}

class B extends Num{

    @Override
    public void setNum(int number, AbstractMediator mediator) {
        super.setNum(number);
        mediator.changeA();
    }
}
