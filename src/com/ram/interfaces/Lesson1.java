package com.ram.interfaces;

public class Lesson1 extends AbstractClass1 implements Eatable,Drinkable{

    @Override
    public void overrideMe() {
        System.out.println("I am overriden by Lesson1");
    }

    public void overrideMe1(){
        System.out.println("I am overMe1");
    }

    @Override
    public void consume() {
        System.out.println("I was common to 2 interf. so I am overridden here at class level");
    }

    public static void main(String[] args) {
        var x = new Lesson1();
        x.overrideMe();
        x.publicMethod1();
        System.out.println(x.x);
        Eatable.useMe();
        x.overrideMe1();
        x.consume();
        x.drinkMe();
        x.a();
        Drinkable d = new Lesson1();
//        Drinkable d = (Drinkable)x;
        System.out.println(d.u);
//        System.out.println(d.statMethd());
        System.out.println(d==x);
        System.out.println(d.equals(x));
    }

}
