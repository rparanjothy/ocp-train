package com.ram.overloading;

public class X {
    private X(){
        System.out.println("I am a PRIVATE const of X and I cannot be created from others");
    }

     X(int i){
         this();
         System.out.println("I am a default const of X and I call the private X() ");
    }
}
