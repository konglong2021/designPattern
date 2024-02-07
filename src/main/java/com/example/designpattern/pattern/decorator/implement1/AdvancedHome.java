package com.example.designpattern.pattern.decorator.implement1;

public class AdvancedHome extends Home{

    public AdvancedHome(){
        additionalCost = 25000;

    }
    @Override
    public double getPrice(){
        return basePrice + additionalCost;
    }
}
