package com.example.designpattern.pattern.prototype.implementatation_1;

abstract class BasicCar implements Cloneable{
    public String modelName;
    public int basePrice = 0, onRoadPrice = 0;
    public String getModelName(){
        return modelName;
    }
    public void setModelName(String name){
        this.modelName = name;
    }

    public BasicCar clone() throws CloneNotSupportedException{
        return (BasicCar)super.clone();
    }
}
