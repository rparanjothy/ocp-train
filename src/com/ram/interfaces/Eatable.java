package com.ram.interfaces;

public interface Eatable {
//    w/o access mode everything is public and abstract
    //    final property/constants;
//    Cannot have variables
    int x1=0;

//    default, private and static methods can have body
    //  default mthd
    default void eatme(){
        System.out.println("Eat Me!");
    }

    default void consume() {
        System.out.println("Consume me!");
    }

    //    Prvt mthd
    private void pvtMthd1(){
        System.out.println(x1);
    }

    //    static methd
    static void useMe(){
        System.out.println("I am a static method");
    };

//    this is abstract method, so no body
    void overrideMe1();
}
