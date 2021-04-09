package com.ram.nestedclasses;

public abstract class NestedClass {
    int outerClassID;
    static int f; // this is more of a type.. which is set via a log in the static inner class
    public class PublicInnerClass{
        int id;
        String name;

        public PublicInnerClass(int id) {
            this.id = id;
            System.out.println("I am public inner class");
            System.out.println("outerClassID:"+outerClassID);

        }
    }

    PublicInnerClass createPublicInnerClass(){
        return  new PublicInnerClass(2);
    }


    public static class PublicStaticInnerClass{
        PublicStaticInnerClass(int x){
            this.idStatic = x;
            System.out.println("I am public static inner class"+idStatic);
            f=x;
            f++;
            System.out.println("f is :"+f);


        }
        int idStatic;

        public int getIdStatic() {
            return idStatic;
        }

        public void setIdStatic(int idStatic) {
            this.idStatic = idStatic;
        }

        public String getNameStatic() {
            return nameStatic;
        }

        public void setNameStatic(String nameStatic) {
            this.nameStatic = nameStatic;
        }

        String nameStatic;
    }
    PublicStaticInnerClass createPublicStaticInnerClass(int x){
        return new PublicStaticInnerClass(x);
    }



    private class PrivateInnerClass{
         private PrivateInnerClass(){
            System.out.println("HI I am PrivateInnerClass instance");
            System.out.println("outerClassID:"+outerClassID);
        }

        int idPriv;



        String namePriv;

        public int getIdPriv() {
            return idPriv;
        }

        public void setIdPriv(int idPriv) {
            this.idPriv = idPriv;
        }

        public String getNamePriv() {
            return namePriv;
        }

        public void setNamePriv(String namePriv) {
            this.namePriv = namePriv;
        }
    }

    PrivateInnerClass createPrivateInnerClass(){
        return new PrivateInnerClass();
    }

   void sayHi(){
        class x{
            String msg;

            public x(String msg) {
                this.msg = msg;

            }

            void ge(){
                System.out.println("ehllo"+this.msg);
            }
        }
       System.out.println(new x("yo you"));
   }

}
