package com.example.demo;

public class Animal implements Barkable{
    String name;
    public Animal(){

    }

    public Animal(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public void bark() {

    }
}
