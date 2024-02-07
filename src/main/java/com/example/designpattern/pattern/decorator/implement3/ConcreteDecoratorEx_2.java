package com.example.designpattern.pattern.decorator.implement3;

public class ConcreteDecoratorEx_2 extends AbstractDecorator{
    public void doJob(){
       System.out.println("");
       System.out.println("***START Ex-2 decorator.***");
       super.doJob();
       System.out.println("Explicitly From Decorator Ex-2");
       System.out.println("***END Ex-2 decorator.***");
    }
}
