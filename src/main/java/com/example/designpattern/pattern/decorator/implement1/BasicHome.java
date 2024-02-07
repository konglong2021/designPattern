package com.example.designpattern.pattern.decorator.implement1;

public class BasicHome extends Home{

    public BasicHome(){
        System.out.println(" The basic home with some standard facilities are ready.");
        System.out.println(" You need to pay $" + this.getPrice() + " for this.");
    }
    @Override
    public double getPrice(){
        return basePrice;
    }
}
