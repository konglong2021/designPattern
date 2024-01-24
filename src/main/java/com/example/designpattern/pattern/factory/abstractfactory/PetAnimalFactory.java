package com.example.designpattern.pattern.factory.abstractfactory;

public class PetAnimalFactory extends AnimalFactory {

    public PetAnimalFactory(){
        System.out.println("You opt for a pet animal factory. ");
    }
    @Override
    protected Tiger createTiger(String color) {
        return new PetTiger(color);
    }

    @Override
    protected Dog createDog(String color) {
        return new PetDog(color);
    }
}
