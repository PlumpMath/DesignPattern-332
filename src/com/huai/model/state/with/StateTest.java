package com.huai.model.state.with;

/**
 * <p>状态模型，目的是消除庞大的条件分支语句，大的分支判断会使得他们难以修改和扩展，
 * 就像我们最早说的刻板印刷一样，任何改变和变化都是致命的。
 * 状态模型通过把各种状态转移逻辑分布到State的子类之间，来减少相互间的依赖。
 * 好比把整个版面改成一个又一个的活字，
 * 此时就容易维护和扩展了。
 * </p>
 * <p>当一个对象的行为取决于他的状态，并且他必须在运行时刻根据状态改变它的行为时，
 * 就可以考虑使用状态模型了。
 * </p>
 * Created by liangyh on 16-1-13.
 */
public class StateTest {
    public static void main(String[] args) {
        Work w = new Work();

        w.setHour(9);
        w.writeProgram();

        w.setHour(10);
        w.writeProgram();

        w.setFinished(false);

        w.setHour(19);
        w.writeProgram();

        w.setHour(23);
        w.writeProgram();
    }
}


abstract class State{
    abstract void changeState(Work work);
}

/**
 * 早上的状态
 */
class MorningState extends State{

    @Override
    public void changeState(Work work) {
        if(work.getHour() < 11){
            System.out.println("hour = "+work.getHour()+", good");
        }else{
            NoonState noonState = new NoonState();
            work.setState(noonState);
            work.writeProgram();
        }
    }
}

/**
 * 中午的状态
 */
class NoonState extends State{

    @Override
    void changeState(Work work) {
        if(work.getHour() < 13){
            System.out.println("hour = "+work.getHour()+", sleepy");
        }else{
            AfternoonState afternoonState = new AfternoonState();
            work.setState(afternoonState);
            work.writeProgram();
        }
    }
}

/**
 * 下午的状态
 */
class AfternoonState extends State{
    @Override
    void changeState(Work work) {
        if(work.getHour() < 17){
            System.out.println("hour = "+work.getHour()+", not bad");
        }else{
            NightState nightState = new NightState();
            work.setState(nightState);
            work.writeProgram();
        }
    }
}

/**
 * 晚上的状态
 */
class NightState extends State{
    @Override
    void changeState(Work work) {
        if(work.isFinished()){
            System.out.println("go back home, good , hour = "+work.getHour());
        }else{
            if(work.getHour() < 21){
                System.out.println("hour = "+work.getHour()+", so bad");
            }else{
                MidnightState midnightState = new MidnightState();
                work.setState(midnightState);
                work.writeProgram();
            }
        }

    }
}

/**
 * 半夜的状态
 */
class MidnightState extends State{
    @Override
    void changeState(Work work) {
        if(work.getHour() >= 21 || work.getHour() < 9){
            System.out.println("hour = "+work.getHour()+", fall asleep");
        }
    }
}

/**
 * 工作类
 */
class Work{
    //时间
    private int hour;
    //是否已经完成当天的任务
    private boolean isFinished;
    //状态
    private State state;

    //早上状态的引用
    private final State morningState;

    public Work(){
        this.morningState = new MorningState();
        state = morningState;
    }
    /**
     * 编写程序
     */
    public void writeProgram(){
        if(state == null) throw new NullPointerException("State object is null");

        state.changeState(this);
        this.state = morningState;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setState(State state){
        this.state = state;
    }
}