package com.example.designpattern.pattern.singleton.implement2;

public class Client {
    public static void main(String[] args){
        System.out.println("***Singleton Pattern Demo.***");
        System.out.println("Trying to make a captain for our team.");
        Captain c1 = Captain.getCaptain();
        System.out.println("Trying to make another captain for our team.");
        Captain c2 = Captain.getCaptain();
        if (c1 == c2){
            System.out.println("c1 and c2 are same instance");
        }

        Captain.CaptainDerived derived1 = c1.new CaptainDerived();
        Captain.CaptainDerived derived2 = c1.new CaptainDerived();

    }
}
