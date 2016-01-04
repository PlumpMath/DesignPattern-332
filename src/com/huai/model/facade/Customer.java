package com.huai.model.facade;

/**
 * Created by liangyh on 15-12-31.
 */
public class Customer {

    public void haveDinner(){
        //如果不用门面模式，那么在这里就需要分别实例化Cook、Customer、Payment，然后调用它们的方法。
        Facade facade = new Facade();
        facade.doServe();
    }
}
