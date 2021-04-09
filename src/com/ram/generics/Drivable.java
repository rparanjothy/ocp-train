package com.ram.generics;

//@FunctionalInterface
public interface Drivable  {


    default void drive() {
        System.out.println("I am default drive");
    }



}
