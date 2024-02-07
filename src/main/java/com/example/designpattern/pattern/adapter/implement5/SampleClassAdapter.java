package com.example.designpattern.pattern.adapter.implement5;

public class SampleClassAdapter extends IntegerValue{

    public int getInteger() {
        return 3 + super.getInteger();
    }
}
