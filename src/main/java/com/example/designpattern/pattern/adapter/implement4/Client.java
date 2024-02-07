package com.example.designpattern.pattern.adapter.implement4;

public class Client {
    public static void main(String[] args){
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designCard(adapter);
        System.out.println(card);
    }
}
