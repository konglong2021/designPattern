package com.example.designpattern.pattern.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        System.out.println("***Factory Method pattern modified demonstration.***");
        AnimalFactory factory;
        // Create a tiger and display its behavior
        // using TigerFactory.
        factory =new TigerFactory();
        factory.createAndDisplayAnimal("yellow");
        // Create a dog and display its behavior
        // using DogFactory.
        factory = new DogFactory();
        factory.createAndDisplayAnimal("white");

        factory = new CatFactory();
        factory.createAndDisplayAnimal("black");
    }
}
