package com.example.designpattern.pattern.adapter.implement5;

public class ObjectAdapter {
    private IIntegerValue myInt;
    public ObjectAdapter(IIntegerValue myInt){
        this.myInt = myInt;
    }

    public int getInteger(){
        return 5 + this.myInt.getInteger();
    }
}
