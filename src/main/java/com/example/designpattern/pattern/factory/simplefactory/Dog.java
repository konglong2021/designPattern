package com.example.designpattern.pattern.factory.simplefactory;

public class Dog implements Animal{

    public Dog(String color) {
        System.out.println("\nA dog with: " + color + " color is created.");
    }
    @Override
    public void displayBehavior() {
        System.out.println("Dog is barking");
        System.out.println("It prefers barking.");
    }
}
