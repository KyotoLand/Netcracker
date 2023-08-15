package com.netcracker.edu.miloserdov.extendedclass;

public class Main {

    public static void main(String[] args){

        ExtendedClass test1 = new ExtendedClass();

        test1.setB((byte)4);
        test1.setD(12345524.232151);
        test1.setI(32221);
        test1.setS("Str");

        ExtendedClass test2 = new ExtendedClass();

        test2.setS("Str");
        test2.setD(12345524.232151);
        test2.setI(32221);
        test2.setB((byte)4);

        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test1.equals(test2));
        System.out.println(test1.toString());

    }

}
