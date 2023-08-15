package com.netcracker.edu.thirdtask.person;

public class Person {
    private String name;
    private String lastname;
    private String patronymic;
    private static StringBuilder staticSb = new StringBuilder();

    Person(String lastname, String name, String patronymic){
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    Person(String lastname){
        this(lastname, null, null);
    }

    Person(String lastname, String name){
        this(name, lastname, null);
    }

    public String getName(){
        staticSb.delete(0, staticSb.length());
        if(name != null){
            if(patronymic != null){
                return staticSb.append(lastname).append(" ").append(name).append(" ").append(patronymic).toString();
            }
            return staticSb.append(lastname).append(" ").append(name).toString();
        }
        return lastname;
    }

}
