package com.huai.model.flyWeight;

import java.util.HashMap;

/**
 * 享元模式。
 * <p>在一个系统中如果有多个相同的对象，那么只共享一份就可以了，不必每个都去实例化一个对象。
 * 比如说一个文本系统，每个字母定一个对象，那么大小写字母一共就是52个，那么就要定义52个对象。
 * 如果有一个1M的文本，那么字母是何其的多，如果每个字母都定义一个对象那么内存早就爆了。
 * 那么如果要是每个字母都共享一个对象，那么就大大节约了资源。
 * 在Flyweight模式中，由于要产生各种各样的对象，所以在Flyweight(享元)模式中常出现Factory模式。
 * Flyweight的内部状态是用来共享的,Flyweight factory负责维护一个对象存储池（Flyweight Pool）
 * 来存放内部状态的对象。
 * Flyweight模式是一个提高程序效率和性能的模式,会大大加快程序的运行速度.应用场合很多</p>
 *
 * <p>String类就应用了这个模式</p>
 *
 * Created by liangyh on 16-1-12.
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();

        factory.add("hello");
        factory.add("hello");
        factory.add("google");
        factory.add("hello");

        int size = factory.size();
        System.out.println("size = "+size);
    }
}

interface FlyWeight{
    void doSomething();
}

class ConcreteFlyWeight implements FlyWeight{
    private String str;

    public ConcreteFlyWeight(String string){
        this.str = string;
    }
    @Override
    public void doSomething() {
        System.out.println("concrete fly weight: "+ str);
    }
}

class FlyWeightFactory{
    private HashMap<String,FlyWeight> map = new HashMap<>();

    public FlyWeightFactory(){

    }

    /**
     * 如果已经存在相同的字符串，就不再实例化FlyWeight对象了。
     * @param object
     */
    public void add(String object){
        if(map.get(object) == null){
            FlyWeight newFlyWeight = new ConcreteFlyWeight(object);
            map.put(object,newFlyWeight);
        }
    }

    public int size(){
        return map.size();
    }
}
