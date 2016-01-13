package com.huai.model.state.without;

/**
 * 不使用状态模型的情况
 * Created by liangyh on 16-1-13.
 */
public class WithoutStateTest {
    public static void main(String[] args) {
        Work w = new Work();

        w.setHour(9);
        w.writeProgram();

        w.setHour(10);
        w.writeProgram();

        w.setFinished(false);

        w.setHour(19);
        w.writeProgram();

        w.setHour(22);
        w.writeProgram();
    }
}

class Work{
    private int hour;
    private boolean isFinished = false;

    public Work(){}

    public Work(int hour,boolean isFinished){
        this.hour = hour;
        this.isFinished =isFinished;
    }

    /**
     * 问题：这个方法太长了
     */
    public void writeProgram(){
        if(hour < 11){
            System.out.println("the current time is "+hour+", good");
        }else if(hour < 13){
            System.out.println("the current time is "+hour+", sleepy");
        }else if(hour < 17){
            System.out.println("the current time is "+hour+", not bad");
        }else{
            if(isFinished){
                System.out.println("the current time is "+hour+", go back home");
            }else{
                if(hour < 21){
                    System.out.println("the current time is "+hour+", so bad");
                }else{
                    System.out.println("the current time is "+hour+", fall asleep");
                }
            }
        }
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
}