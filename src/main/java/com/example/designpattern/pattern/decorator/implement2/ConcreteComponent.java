package com.example.designpattern.pattern.decorator.implement2;

public class ConcreteComponent extends Component{
    @Override
    public void makeHouse() {
        System.out.println("original House is complete. It is closed for modification.");
    }
}
