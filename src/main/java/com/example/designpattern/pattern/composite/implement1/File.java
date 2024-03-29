package com.example.designpattern.pattern.composite.implement1;

public abstract class File {
    private String name;

    public File(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void ls();
}
