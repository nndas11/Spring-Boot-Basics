package com.example.demo.annotations;

@VeryImportant
public class Pet {

    @FieldImportant
    String name;
    int age;

    @RunImmediately(times = 3)
    public void walk(){
        System.out.println("Walking!!");
    }

    public void run(){
        System.out.println("Running!!");
    }
}
