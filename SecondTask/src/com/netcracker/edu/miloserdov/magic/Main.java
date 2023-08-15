package com.netcracker.edu.miloserdov.magic;

public class Main {

    public static void main(String[] args){

        Magic test = new MagicImpl();

        test.setNumber(12345);

        test.doMagic();

        System.out.println(test.getNumber());

    }
}
