package com.example.designpattern.pattern.factory.abstractfactory;

public class Client {
    public static void main(String[] args) {
        System.out.println("***Abstract Factory Pattern Demo.***\n");
        AnimalFactory animalFactory;
        // Making a wild dog and wild tiger through

        // WildAnimalFactory
        animalFactory = new WildAnimalFactory();
        Dog dog = animalFactory.createDog("white");
        Tiger tiger = animalFactory.createTiger("golden and cinnamon");
        dog.displayMe();
        tiger.aboutMe();
        tiger.inviteDog(dog);
        System.out.println("\n************\n");
        // Making a pet dog and pet tiger through
        // PetAnimalFactory now.
        animalFactory = new PetAnimalFactory();
        dog = animalFactory.createDog("black");
        tiger = animalFactory.createTiger("yellow");
        dog.displayMe();
        tiger.aboutMe();
        tiger.inviteDog(dog);
    }
}
