package com.example.designpattern.pattern.factory.simplefactory;

public class Tiger implements Animal{

    public Tiger(String color) {
        System.out.println("\nA tiger with: " + color + " color is created.");
    }
    @Override
    public void displayBehavior() {
        System.out.println("Tiger is hunting");
        System.out.println("It loves to roam in a jungle.");
    }
}
