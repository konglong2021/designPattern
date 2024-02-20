package com.example.designpattern.pattern.composite.implement1;

public class BinaryFile extends File{

    private long size;
    public BinaryFile(String name,long size){
        super(name);
        this.size = size;
    }


    @Override
    public void ls() {
        System.out.println(getName() + " (" + size + " bytes)");
    }
}
