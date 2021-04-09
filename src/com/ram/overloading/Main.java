package com.ram.overloading;

import java.math.BigDecimal;

public class Main {
    static
    {
        System.out.println("I am mains Static initializer");
    }

    {
        System.out.println("I am mains instance initializer");
    }

//    Cannot have recursion.. ab:ba
    public Main(){
//        this(1);
        System.out.println("I am mains no arg const");
//        cannot create instance of X because it has a private const.
//        new X();
//        this X(int) is a default const, so visible in the same pkg, and this calls the private X(), fun!
        new X(1);
    }

    public Main(int x){
        this();
        System.out.println("I am mains other const with int arg");
    }

//    overloaded methods same name, same return type, diff signature, can have diff access mods
    public static int m1(){
        return 1;
    }

    public  int m1(int x){
        return 2;
    }

    private int m1(int x,int y){
        return 3;
    }

    private int m1(int x,char y){
        int[] c = {1,2,3,4};
        return 4;
    }

//    vararg
    private int m1(char... x){
        System.out.println("x length: "+x.length);
        System.out.println(x[1]);
        return 5;
    }
    public static void main(String[] args) {
        System.out.println("overloading");
        System.out.println(m1());
        System.out.println(new Main().m1(1));
        System.out.println(new Main().m1(1,1));
        System.out.println(new Main().m1(1,'c'));
        System.out.println(new Main().m1('c','d','d','3'));
//      new with a diff const
        System.out.println(new Main(1).m1('3'));
        /*
        I am mains instance initializer
        I am mains no arg const
        I am a PRIVATE const of X and I cannot be created from others
        I am a default const of X and I call the private X()
        I am main
         */
        BigDecimal b = BigDecimal.TEN;
        System.out.println(b.multiply(BigDecimal.valueOf(10)));

//        Enums
        /*
            Enums provide instances (public static final ) of a specific type.
            instead of saying Product car = new Product(), we just say car, watch, belt
         */

        MyProducts mp = new MyProducts("casio",Products.WATCH);
    }
}
