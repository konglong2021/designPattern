package com.example.designpattern.pattern.factory.simplefactory;

public class Cat implements Animal{

    public Cat(String color){
        System.out.println("\nA cat with: " + color + " color is created.");
    }
    @Override
    public void displayBehavior() {
        System.out.println("Cat is meowing");
        System.out.println("It prefers meowing.");
    }
}
