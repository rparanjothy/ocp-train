package com.ram.IO;

import com.ram.overloading.SerializedBus;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public void xxx() {
        try(ObjectOutputStream ojo=new ObjectOutputStream(new FileOutputStream("busObj"));
            ObjectInputStream oji = new ObjectInputStream(new FileInputStream("busObj"))) {

            Serializable c = new SerializedBus();
            ojo.writeObject(c);

            SerializedBus b2= (SerializedBus) oji.readObject();
            /*
            Transient instance var - j which is initialized to "ads" wont be here.

            null
            SerializedBus{i=10, j='null'}

            */
            System.out.println(b2.toString());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } ;
    }

    public static void main(String[] args)  {



        System.out.println("I am IO Main");

        try(InputStream i = new FileInputStream("resources/data.txt");
            InputStream i1 = new FileInputStream("resources/dataOut.txt");

            OutputStream o = new FileOutputStream("resources/dataOut.txt");
            OutputStream o1 = new FileOutputStream("resources/dataOut1.txt");){
//            Writer o = new FileOutputStream("resources/dataOut.txt");){
            System.out.println("I am inside Try");
            System.out.println(i.available());
            byte[] bf = new byte[2];
            System.out.println(i.read(bf));
            System.out.println(bf[0]);
            o.write(bf);

            i.transferTo(o);

            Path p = Paths.get("resources/data.txt");
            System.out.println(p.getFileName());
            System.out.println(p.getFileSystem());
            System.out.println(p.iterator().next());
            /*
            data.txt
            sun.nio.fs.MacOSXFileSystem@75bd9247
            resources
             */

//            This does not write anything bc the input stream would be closed; so have a new i1
//            i.transferTo(o1);
             i1.transferTo(o1);

             Console c = System.console();
                System.out.println(c);


        }
        catch (Exception e){
            e.printStackTrace();
        }

//        Object Serialization
        try(ObjectOutputStream ojo=new ObjectOutputStream(new FileOutputStream("busObj"));
            ObjectInputStream oji = new ObjectInputStream(new FileInputStream("busObj"))) {

            Serializable c = new SerializedBus();
            ojo.writeObject(c);

            SerializedBus b2= (SerializedBus) oji.readObject();
            /*
            Transient instance var - j which is initialized to "ads" wont be here.

            null
            SerializedBus{i=10, j='null'}

            */
            System.out.println(b2.toString());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } ;


    }
}
