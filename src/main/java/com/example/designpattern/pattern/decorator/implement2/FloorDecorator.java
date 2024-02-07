package com.example.designpattern.pattern.decorator.implement2;

public class FloorDecorator extends AbstractDecorator{
    public void makeHouse(){
        super.makeHouse();
        System.out.println("***Floor decorator is in action.***");
        addFloor();
    }
    private void addFloor(){
        System.out.println("I am making an additional floor on top of it.");
    }
}
