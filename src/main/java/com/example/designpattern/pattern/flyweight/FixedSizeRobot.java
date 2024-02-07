package com.example.designpattern.pattern.flyweight;

public class FixedSizeRobot implements Robot{
    private final String robotTypeCreated;

    public FixedSizeRobot(){
        robotTypeCreated = "A fixed size robot created";
        System.out.print(robotTypeCreated);
    }
    @Override
    public void showMe(String color) {
        System.out.print(" with "+ color +" (default) color");
    }
}
