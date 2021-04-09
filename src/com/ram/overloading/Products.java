package com.ram.overloading;

public enum Products {


    FOOD,WATCH,BELT,PEN(2);

    @Override
    public String toString() {
        return "Products{" +
                "z=" + z +
                '}';
    }

    public int z;

    Products(){
        System.out.println("I am Product ENUM default access mod const called for: "+this.name());
        z=-1;
    }

    private Products(int i){
        this.z=i;
        System.out.println("I am Product ENUM private access mod const(x) called for: "+this.name());
        this.toString();

    }

    /*
    I am Product ENUM default access mod const called for: FOOD
    I am Product ENUM default access mod const called for: WATCH
    I am Product ENUM default access mod const called for: BELT
    I am Product ENUM private access mod const(x) called for: PEN

    Products{z=-1}
    Products{z=-1}
    Products{z=-1}
    Products{z=2}
     */


}
