package com.ram.nestedclasses;

import java.lang.management.ManagementFactory;

public class Main extends NestedClass {
    public static void main(String[] args) {
        NestedClass.PublicStaticInnerClass psic= new NestedClass.PublicStaticInnerClass(33);
        psic.setIdStatic(2);
        System.out.println(psic.getIdStatic());
        Main m = new Main();
        Object c = m.createPrivateInnerClass();
        System.out.println(c);
        NestedClass.PublicInnerClass pubic = m.createPublicInnerClass();


    }
}
