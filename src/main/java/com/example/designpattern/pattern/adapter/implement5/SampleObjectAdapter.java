package com.example.designpattern.pattern.adapter.implement5;

public class SampleObjectAdapter {
    private IIntegerValue myInt;

    public SampleObjectAdapter(IIntegerValue myInt){
        this.myInt = myInt;
    }
    public int getInteger(){
        return 4 + this.myInt.getInteger();
    }
}
