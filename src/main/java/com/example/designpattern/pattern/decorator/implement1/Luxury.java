package com.example.designpattern.pattern.decorator.implement1;

abstract class Luxury extends Home{
    protected Home home;
    public double luxuryCost;
    public Luxury(Home home){
        this.home = home;
    }

    @Override
    public double getPrice(){
        return home.getPrice();
    }
}
