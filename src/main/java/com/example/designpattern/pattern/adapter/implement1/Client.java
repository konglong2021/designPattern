package com.example.designpattern.pattern.adapter.implement1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        System.out.println("***Adapter Pattern Demo.***\n");
        RectInterface rectangle = new Rectangle(20,10);
        TriInterface triangle = new Triangle(20,10);
        RectInterface adapter = new Adapter(triangle);
        List<RectInterface> rectangleObjects = new ArrayList<RectInterface>();
        rectangleObjects.add(rectangle);
        rectangleObjects.add(adapter);
        System.out.println("Processing the following objects:\n");
        for(RectInterface rectObject : rectangleObjects){
            System.out.println("Area: " + getDetails(rectObject) + " square units.\n");
        }
    }

    static double getDetails(RectInterface rect){
        rect.aboutMe();
        return rect.calculateArea();
    }
}
