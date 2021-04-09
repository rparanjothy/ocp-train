package com.ram.interfaces;

public abstract class AbstractClass1 {
//    regular methods in abstract class needs a body
    void abstractMethod1(){
        System.out.println("I am an abstract method");
    };

    private void privateMethod1(){
        System.out.println("Iam a private methd inside an abstract class");
    }

    //can not have a default method inside an abstract class

    public void publicMethod1(){
        System.out.println("I am a public methd in abs. class");
    }

    private int i=10;
    int x=10;

    abstract void overrideMe();

//    abstract methods cannot have body
//    abstract void overrideMe1(){
//        System.out.println("I am abs mthd and I have body");
//    };

//    a() is in some interface, thse are not connected
//    but I define it here. but his has to be public so the caller can see this
    public void a(){
        System.out.println("I am a from Abstract class");
    }

}
