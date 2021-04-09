package com.ram.overloading;

import java.io.Serializable;

public class SerializedBus implements Serializable {
    volatile int i = 10;

    @Override
    public String toString() {
        return "SerializedBus{" +
                "i=" + i +
                ", j='" + j + '\'' +
                '}';
    }

    transient volatile String j = "ads";

}
