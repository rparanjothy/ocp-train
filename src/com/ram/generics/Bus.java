package com.ram.generics;

public class Bus extends Vehicle implements Cloneable{
    public Bus(Integer i){
        this.id = i ;
    }
    public Bus clone() throws CloneNotSupportedException {
        return (Bus) super.clone();
    }

    public void drive(){
        System.out.println("I am Bus - drive");
    }


}