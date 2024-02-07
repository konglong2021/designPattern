package com.example.designpattern.pattern.decorator.implement4;

public abstract class PCDecorator {
    public double price;
    public double additionalCost;
    public PCDecorator(){
        this.price = 500.0;
        this.additionalCost = 0.0;

    }
    public abstract double getPrice();
}
