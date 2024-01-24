package com.example.designpattern.pattern.prototype.implementatation_1;

import java.util.Random;

public class Nano extends BasicCar{
    public Nano(String modelName){
        this.modelName = modelName;
        basePrice = 5000;
        onRoadPrice = basePrice + (new Random()).nextInt(1000);
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException{
        return (Nano)super.clone();
    }

    @Override
    public String toString(){
        return "Model: "+ modelName + "\nPrice: "+ onRoadPrice;
    }
}
