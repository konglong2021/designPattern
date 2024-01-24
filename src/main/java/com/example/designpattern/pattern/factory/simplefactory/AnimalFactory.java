package com.example.designpattern.pattern.factory.simplefactory;

abstract class AnimalFactory {
    public void createAndDisplayAnimal(String color) {
        Animal animal;
        animal = createAnimal(color);
        animal.displayBehavior();
    }
    protected abstract Animal createAnimal(String color);

}
