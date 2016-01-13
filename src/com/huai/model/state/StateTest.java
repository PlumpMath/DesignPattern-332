package com.huai.model.state;

/**
 * Created by liangyh on 16-1-13.
 */
public class StateTest {
    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());

        c.request();
        c.request();
        c.request();
        c.request();

        System.out.println();
    }
}

abstract class State{
    public abstract void handle(Context context);
}

class ConcreteStateA extends State{
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State{
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}

class Context{
    private State state;

    public Context(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("the current state is: "+state.getClass().getName());
    }

    public void request(){
        state.handle(this);
    }
}
















