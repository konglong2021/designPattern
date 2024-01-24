package com.example.designpattern.pattern.factory.abstractfactory;

public class FactoryProvider {
    public static AnimalFactory getFactory(String type){
        if (type.contains("wild")){
            return new WildAnimalFactory();
        }else if(type.contains("pet")){
            return new PetAnimalFactory();
        }else{
            throw new IllegalArgumentException("You need to pass either 'wild' or 'pet' as an argument");
        }
    }
}
