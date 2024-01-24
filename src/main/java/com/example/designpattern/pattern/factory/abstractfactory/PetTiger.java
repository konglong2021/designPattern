package com.example.designpattern.pattern.factory.abstractfactory;

public class PetTiger implements Tiger{

    public PetTiger(String color){
        System.out.println("A pet tiger with: " + color + " color is created.");
    }
    @Override
    public void aboutMe() {
        System.out.println("The " + this + " says: Halum. play in an animal circus.");
    }

    @Override
    public void inviteDog(Dog dog) {
        System.out.println("The "+ this + " says: I saw a "+ dog + " in my town.");
    }

    @Override
    public String toString(){
        return "pet tiger";
    }
}
