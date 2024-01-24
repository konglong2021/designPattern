package com.example.designpattern.pattern.factory.simplefactory;

public class CatFactory extends AnimalFactory {

    @Override
    protected Animal createAnimal(String color) {
        return new Cat(color);
    }
}
