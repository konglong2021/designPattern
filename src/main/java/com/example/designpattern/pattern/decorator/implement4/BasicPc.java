package com.example.designpattern.pattern.decorator.implement4;

public class BasicPc extends PCDecorator {
    public BasicPc(){
        System.out.println(" The basic PC with some standard accessories are ready.");
        System.out.println(" You need to pay $" + this.getPrice() + " for this.");
    }

    @Override
    public double getPrice() {
        return price;
    }
}
