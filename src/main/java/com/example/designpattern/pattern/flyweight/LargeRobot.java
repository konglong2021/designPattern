package com.example.designpattern.pattern.flyweight;

public class LargeRobot implements Robot{

    private final String robotTypeCreated;
    public LargeRobot(){
        robotTypeCreated = "A large robot created";
        System.out.print(robotTypeCreated);
    }
    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color");
    }
}
