package com.example.designpattern.pattern.prototype.implementatation_1;

public class CarMaker {
    BasicCar nano,ford;
    public CarMaker(){
        nano = new Nano("Nano XM624 cc");
        ford = new Ford("Ford Aspire");
    }

    public BasicCar getNano() throws CloneNotSupportedException{
        return nano.clone();
    }

    public BasicCar getFord() throws CloneNotSupportedException{
        return ford.clone();

    }
}
