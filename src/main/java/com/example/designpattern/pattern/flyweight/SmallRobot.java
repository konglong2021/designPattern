package com.example.designpattern.pattern.flyweight;

public class SmallRobot implements Robot {

    private final String robotTypeCreated;

    public SmallRobot() {
        robotTypeCreated = "A small robot created";
        System.out.print(robotTypeCreated);
    }


    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color");
    }
}
