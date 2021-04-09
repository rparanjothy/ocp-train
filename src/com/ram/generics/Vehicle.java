package com.ram.generics;


import java.sql.Driver;

public abstract class Vehicle implements Comparable<Vehicle>, Drivable {


    Integer id;

    public int compareTo(Vehicle to){
        return this.id.compareTo(to.id);
    }
}
