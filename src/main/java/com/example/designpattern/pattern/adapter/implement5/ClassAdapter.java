package com.example.designpattern.pattern.adapter.implement5;

public class ClassAdapter extends IntegerValue{
    public int getInteger() {
        return 2+super.getInteger();
    }
}
