package com.ram.overloading;

import java.util.Arrays;

public class MyProducts {
    private String name;
    private Products prd;

    @Override
    public String toString() {
        return "MyProducts{" +
                "name='" + name + '\'' +
                ", prd=" + prd +
                '}';
    }

    //    we create a product with a type.. instead of saying WATCH is an instance of PRODUCT, we just say WATCH
    public MyProducts(String name, Products product_type){
        this.name=name;
        this.prd=product_type;
        System.out.println(this.prd.name());
        System.out.println(this.prd.ordinal());
        System.out.println(this.toString());

        System.out.println(Arrays.stream(Products.values()).count());

        Arrays.stream(Products.values()).forEach(System.out::println);
        Arrays.stream(Products.values()).forEach(e->System.out.println(e.ordinal()+" "+e.name()));

    }
}
