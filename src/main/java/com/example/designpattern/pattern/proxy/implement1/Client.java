package com.example.designpattern.pattern.proxy.implement1;

public class Client {
    public static void main(String[] args){
        System.out.println("***Proxy Pattern Demo.***");
        Subject proxy = new ProxySubject();
        proxy.doSomeWork();
    }
}
