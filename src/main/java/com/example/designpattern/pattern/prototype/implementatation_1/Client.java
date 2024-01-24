package com.example.designpattern.pattern.prototype.implementatation_1;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("***Prototype Pattern Demo.***\n");
        BasicCar nano = new Nano("Nano XM624 cc");
        System.out.println(nano);
        System.out.println("--------");
        BasicCar cloneCar;
        cloneCar = nano.clone();
        printCarDetails(cloneCar);
        System.out.println("--------\n");
        //working with a Ford car copy
        BasicCar ford = new Ford("Ford Aspire");
        System.out.println(ford);
        System.out.println("--------");

        //Getting a Cloned version of ford
        cloneCar = ford.clone();
        printCarDetails(cloneCar);
        System.out.println("--------\n");
    }

    private static void printCarDetails(BasicCar car){
        System.out.println("Editing a cloned model:");
        System.out.println("Model: "+ car.modelName);
        car.onRoadPrice += 100;
        System.out.println("It's on-road Price: $"+ car.onRoadPrice);
    }
}
