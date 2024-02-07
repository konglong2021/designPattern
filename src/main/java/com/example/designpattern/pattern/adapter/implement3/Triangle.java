package com.example.designpattern.pattern.adapter.implement3;

public class Triangle implements TriInterface{
    public double base;
    public double height;

    public Triangle(int b , int h){
        this.base = b;
        this.height = h;
    }
    @Override
    public void aboutTriangle() {
        System.out.println("Triangle object with base: " + this.base + " unit and height: " + this.height + " unit.");
    }

    @Override
    public double calculateAreaOfTriangle() {
        return 0.5 * base * height;
    }
}
