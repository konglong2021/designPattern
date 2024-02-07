package com.example.designpattern.pattern.proxy.implement1;

public class ConcreteSubject extends Subject{

    ConcreteSubject(){}
    @Override
    public void doSomeWork() {
        System.out.println("The doSomeWork() is executed.");
    }
}
