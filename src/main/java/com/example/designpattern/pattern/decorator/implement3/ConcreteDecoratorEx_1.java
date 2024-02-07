package com.example.designpattern.pattern.decorator.implement3;

public class ConcreteDecoratorEx_1 extends AbstractDecorator{
    public void doJob(){
        super.doJob();
        System.out.println("I am explicitly from Ex_1 decorator.");
    }
}
