package com.huai.model.momento;

/**
 * Created by liangyh on 16-1-13.
 */
public class MomentoTest {

    public static void main(String[] args) {
        Originator originator = new Originator("hello");

        Momento momento = originator.createMomento();

        System.out.println(originator.getNote());

        originator.setNote("google");
        System.out.println(originator.getNote());

        originator.restoreMomento(momento);
        System.out.println(originator.getNote());
    }
}

/**
 * 备忘录的发起者，负责产生和恢复备忘录
 */
class Originator{
    public String note;

    public Originator(String note){
        this.note = note;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return this.note;
    }
    public Momento createMomento(){
        return new Momento(this.note);
    }

    public void restoreMomento(Momento momento){
        this.setNote(momento.getNote());
    }
}

/**
 * 备忘录类
 */
class Momento{
    private String note;

    public Momento(){}

    public Momento(String note){
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

/**
 * 备忘录的看管者，负责备忘录的设置和读取
 */
class CareTaker{
    private Momento momento;

    public CareTaker(Momento momento){
        this.momento = momento;
    }

    public Momento getMomento() {
        return momento;
    }

    public void setMomento(Momento momento) {
        this.momento = momento;
    }
}
