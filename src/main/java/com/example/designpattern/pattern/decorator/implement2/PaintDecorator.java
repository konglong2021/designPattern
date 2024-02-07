package com.example.designpattern.pattern.decorator.implement2;

public class PaintDecorator extends AbstractDecorator{
    public void makeHouse(){
        super.makeHouse();
        System.out.println("***Paint decorator is in action now.***");
        paintHouse();
    }

    private void paintHouse(){
        System.out.println("I am painting the house.");
    }
}
