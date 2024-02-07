package com.example.designpattern.pattern.proxy.implement2;

public class Client {
    public static void main(String[] args){
        System.out.println("*** Modified Proxy Pattern Demo.***");
        Subject proxy = new ProxySubject();
        proxy.doSomeWork("Admin");
        proxy.doSomeWork("Kate1");
    }
}
