package com.huai.model.visitor;

/**
 *<p> 优点
 *符合单一职责原则：凡是适用访问者模式的场景中，
 * 元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作，
 * 使用访问者模式一方面符合单一职责原则，另一方面，因为被封装的操作通常来说都是易变的，
 * 所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展。
 *扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
 *</p>
 * <p>
 *缺点
 *增加新的元素类比较困难。通过访问者模式的代码可以看到，在访问者类中，
 * 每一个元素类都有它对应的处理方法，也就是说，每增加一个元素类都需要修改访问者类
 * （也包括访问者类的子类或者实现类），修改起来相当麻烦。也就是说，在元素类数目不确定的情况下，
 * 应该慎用访问者模式。所以，访问者模式比较适用于对已有功能的重构，比如说，一个项目的基本功能已经确定下来，
 * 元素类的数据已经基本确定下来不会变了，会变的只是这些元素内的相关操作，这时候，
 * 我们可以使用访问者模式对原有的代码进行重构一遍，这样一来，就可以在不修改各个元素类的情况下，
 * 对原有功能进行修改。
 *</p>
 * <p>
 *适用场景
 *假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，
 * 则可以使用访问者模式来把这些操作封装到访问者中去。
 *假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，也可以将这些重复的操作封装到访问者中去。
 *</p>
 *
 * Created by liangyh on 16-1-12.
 */
public class VisitorTest {
    public static void main(String[] args) {
        Component component = new ComponentImpl();
        Visitor visitor = new VisitorImpl();

        component.accept(visitor);
    }
}

interface Component{
    void doSomething();
    void accept(Visitor visitor);
}

class ComponentImpl implements Component{
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void accept(Visitor visitor) {
        //把自己的引用传给访问者
        visitor.visit(this);
    }
}

interface Visitor{
    void visit(Component component);
}

class VisitorImpl implements Visitor{

    public VisitorImpl(){}

    /**
     * 从这里引入被访问者的对象的引用
     * @param component
     */
    @Override
    public void visit(Component component){
        component.doSomething();
    }
}

