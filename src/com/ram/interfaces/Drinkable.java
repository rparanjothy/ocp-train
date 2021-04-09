package com.ram.interfaces;

public interface Drinkable {
    int u=1;
    default void consume() {
        System.out.println("Consume me!");
    }

    default void drinkMe(){
        System.out.println("Drink me!");
    }

    void a();

    static void statMethd(){
        System.out.println("Iam a s methd");
    }
}
