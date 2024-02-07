package com.example.designpattern.pattern.proxy.implement1;

public class ProxySubject extends Subject{

    private Subject subject;

    public ProxySubject(){
        if (subject == null){
            subject = new ConcreteSubject();
        }
    }
    @Override
    public void doSomeWork() {
        System.out.println("The proxy call is happening now.");
        subject.doSomeWork();
    }
}
