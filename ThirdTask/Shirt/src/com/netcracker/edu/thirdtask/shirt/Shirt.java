package com.netcracker.edu.thirdtask.shirt;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    @Override
    public String toString(){
        return "id: " + id +
                " | Description: " + description +
                " | Color: " + color +
                " | Size: " + size;
    }

    public void getFromString(String shirt){
        StringTokenizer tokenizer = new StringTokenizer(shirt, ",");

        try{
            id = tokenizer.nextToken().trim();
            description = tokenizer.nextToken().trim();
            color = tokenizer.nextToken().trim();
            size = tokenizer.nextToken().trim();
        }catch(NoSuchElementException e){}
    }

    public static Shirt[] getFromStringArray(String[] shirts){
        Shirt[] res = new Shirt[shirts.length];
        for ( int i = 0; i < shirts.length; i++){
            res[i] = new Shirt();
            res[i].getFromString(shirts[i]);
        }
        return res;
    }

    public static void arrayToString(Shirt[] shirts){
        for (int i = 0; i<shirts.length; i++){
            System.out.println(shirts[i].toString());
        }
    }

}
