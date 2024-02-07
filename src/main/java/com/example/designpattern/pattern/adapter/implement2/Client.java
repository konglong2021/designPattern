package com.example.designpattern.pattern.adapter.implement2;

public class Client {
    public static void main(String[] args){
        System.out.println("*** Adapter Pattern Demo.***");
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
        Triangle t = new Triangle(50,10);
        System.out.println("Area of Triangle is: " + calculatorAdapter.getArea(t) + " square units.\n");
    }
}
