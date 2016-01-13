package com.huai.model.command;

/**
 * Created by liangyh on 16-1-13.
 */
public class CommandTest {

    public static void main(String[] args) {
        // 命令接收者Receiver
        Tv myTv = new Tv();
        // 开机命令ConcreteCommond
        CommandOn on = new CommandOn(myTv);
        // 关机命令ConcreteCommond
        CommandOff off = new CommandOff(myTv);
        // 频道切换命令ConcreteCommond
        CommandChange channel = new CommandChange(myTv, 2);
        // 命令控制对象Invoker
        Control control = new Control(on, off, channel);

        // 开机
        control.turnOn();
        // 切换频道
        control.changeChannel();
        // 关机
        control.turnOff();
    }
}


//执行命令的接口
interface Command {
    void execute();
}

//命令接收者Receiver
class Tv {
    public int currentChannel = 0;

    public void turnOn() {
           System.out.println("The televisino is on.");
        }

    public void turnOff() {
           System.out.println("The television is off.");
        }

    public void changeChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Now TV channel is " + channel);
    }
}


//开机命令ConcreteCommand
class CommandOn implements Command {
    private Tv myTv;

    public CommandOn(Tv tv) {
        myTv = tv;
    }

    public void execute() {
        myTv.turnOn();
    }
}

//关机命令ConcreteCommand
class CommandOff implements Command {
    private Tv myTv;

    public CommandOff(Tv tv) {
        myTv = tv;
    }

    public void execute() {
        myTv.turnOff();
    }
}

//频道切换命令ConcreteCommand
class CommandChange implements Command {
    private Tv myTv;

    private int channel;

    public CommandChange(Tv tv, int channel) {
        myTv = tv;
        this.channel = channel;
    }

    public void execute() {
        myTv.changeChannel(channel);
    }
}


//可以看作是遥控器Invoker
class Control {
    private Command onCommand, offCommand, changeChannel;

    public Control(Command on, Command off, Command channel) {
        onCommand = on;
        offCommand = off;
        changeChannel = channel;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }

    public void changeChannel() {
        changeChannel.execute();
    }
}
