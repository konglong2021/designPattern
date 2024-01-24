package com.example.designpattern.pattern.factory.abstractfactory;

public class WildAnimalFactory extends AnimalFactory{

    public WildAnimalFactory() {
        System.out.println("You opt for a wild animal factory. ");
    }
    @Override
    protected Tiger createTiger(String color) {
        return new WildTiger(color);
    }

    @Override
    protected Dog createDog(String color) {
        return new WildDog(color);
    }
}
