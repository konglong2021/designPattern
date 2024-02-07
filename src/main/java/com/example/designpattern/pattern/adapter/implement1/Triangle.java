package com.example.designpattern.pattern.adapter.implement1;

public class Triangle implements TriInterface{
    double baseLength;
    double height;

    public Triangle(double length, double height){
        this.baseLength = length;
        this.height = height;
    }
    @Override
    public void aboutTriangle() {
        System.out.println("Shape type: Triangle.");
    }

    @Override
    public double calculateTriangleArea() {
        return 0.5 * baseLength * height;
    }
}
