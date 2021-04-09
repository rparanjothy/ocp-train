package com.ram.generics;

public class Car extends Vehicle{

    public Car(Integer i){
        this.id = i ;
    }

    public void drive(){
        System.out.println("I am car - drive"+","+id);
    }


}