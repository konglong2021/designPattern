package com.example.designpattern.pattern.composite.implementself;

public abstract class Tree {
    private String name;

    public Tree(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void printStructure();
}
