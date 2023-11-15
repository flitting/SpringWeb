package com.example.demo;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
        public void bark(){
        System.out.println("WANG");
    }
}
