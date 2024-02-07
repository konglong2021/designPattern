package com.example.designpattern.pattern.decorator.implement4;

public class AdvancePC extends PCDecorator{

    public AdvancePC(){
        additionalCost = 5000;
    }
    @Override
    public double getPrice() {
        return price + additionalCost;
    }
}
