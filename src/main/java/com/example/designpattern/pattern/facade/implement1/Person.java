package com.example.designpattern.pattern.facade.implement1;

public class Person {
    String name;
    double assetValue;
    boolean previousLoanExit;
    public Person(String name, double assetValue, boolean previousLoanExit){
        this.name = name;
        this.assetValue = assetValue;
        this.previousLoanExit = previousLoanExit;
    }
}
