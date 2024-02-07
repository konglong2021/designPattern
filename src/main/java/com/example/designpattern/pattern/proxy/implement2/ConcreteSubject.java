package com.example.designpattern.pattern.proxy.implement2;

public class ConcreteSubject extends Subject{
    @Override
    public void doSomeWork(String user) {
        System.out.println(user + " invokes the method-doSomeWork().");
    }
}
