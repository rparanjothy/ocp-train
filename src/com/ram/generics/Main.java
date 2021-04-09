package com.ram.generics;


import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args)  {
        Main a = new Main();
//        PriceChecker<Car> pc = new PriceChecker<>();
        PriceChecker<Drivable> pc = new PriceChecker<>();
        pc.setA(new Car(12));
        pc.show();
//        pc.setA(new Bus());
//        java: incompatible types: com.ram.generics.Bus cannot be converted to com.ram.generics.Car
        pc.setA(new Bus(7));
        pc.show();

        int p = new Bus(9).compareTo(new Car(9));
        System.out.println(p);

        Vehicle[] vehicles = {new Car(13),new Bus(2),new Car(22)};
        System.out.println("B4"+":"+vehicles);
        Arrays.sort(vehicles);
        System.out.println("B4"+":"+vehicles);

        for (var v : vehicles){
            System.out.println(v.id);
        }

        VehicleComparator vc=new VehicleComparator();
        System.out.println("vehicle Comp : "+vc.compare(new Car(1),new Bus(1)));

        Arrays.sort(vehicles, vc);


        for (var v : vehicles){
            System.out.println(v.id);
        }

        try{
            Bus b2=new Bus(2).clone();
            System.out.println(b2);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        Drivable c = new Car(11);
        Car cc = (Car)c;
        System.out.println(cc);

        Drivable ccc = cc;
        Drivable ccc2 = new Car(9);

        System.out.println(ccc);
        System.out.println(ccc2);



    }
}
