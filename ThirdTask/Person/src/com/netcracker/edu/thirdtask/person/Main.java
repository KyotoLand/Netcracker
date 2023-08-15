package com.netcracker.edu.thirdtask.person;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person test1 = new Person("Miloserdov", "Ivan", "Mikhailovich");
        Person test2 = new Person("Miloserdov");
        Person test3 = new Person("Miloserdov", "Ivan");

        System.out.println(test1.getName());
        System.out.println(test2.getName());
        System.out.println(test3.getName());
    }
}
