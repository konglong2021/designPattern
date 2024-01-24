package com.example.designpattern.pattern.factory.abstractfactory;

public abstract class AnimalFactory {
    protected abstract Tiger createTiger(String color);
    protected abstract Dog createDog(String color);
}
