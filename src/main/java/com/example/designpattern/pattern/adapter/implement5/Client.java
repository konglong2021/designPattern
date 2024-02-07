package com.example.designpattern.pattern.adapter.implement5;

public class Client {
    public static void main(String[] args){
//        System.out.println("***Class and Object Adapter Demo.***");
//        ClassAdapter cal = new ClassAdapter();
//        System.out.println("Class Adapter is returning :" + cal.getInteger());
//
//        ClassAdapter ca2 = new ClassAdapter();
//        ObjectAdapter oa = new ObjectAdapter(new IntegerValue());
//        System.out.println("Object Adapter is returning :" + oa.getInteger());

        System.out.println("***Class and Object Adapter Demo.***");
        SampleClassAdapter cal = new SampleClassAdapter();
        System.out.println("Class Adapter is returning : " + cal.getInteger());

//        SampleClassAdapter ca2 = new SampleClassAdapter();
        SampleObjectAdapter oa = new SampleObjectAdapter(new IntegerValue());
        System.out.println("Object Adapter is returning : " + oa.getInteger());
    }
}
