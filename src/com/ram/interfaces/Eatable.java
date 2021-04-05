package com.ram.interfaces;

public interface Eatable {
    default void eatme(){
        System.out.println("Eat Me!");
    }
}
