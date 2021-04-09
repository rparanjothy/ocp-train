package com.ram.generics;

public class PriceChecker<T> {
    T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    void show(){
        System.out.println(this.a.toString());
        Drivable d = (Drivable) a;
        d.drive();

    }
}
