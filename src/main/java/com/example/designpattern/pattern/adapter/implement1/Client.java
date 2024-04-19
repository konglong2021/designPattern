package com.example.designpattern.pattern.adapter.implement1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    /**
     * The main method demonstrates the use of the Adapter Pattern.
     */
    public static void main(String[] args){
        System.out.println("***Adapter Pattern Demo.***\n");

        // Create instances of Rectangle and Triangle
        RectInterface rectangle = new Rectangle(20,10);
        TriInterface triangle = new Triangle(20,10);

        // Create an adapter for the Triangle interface
        RectInterface adapter = new Adapter(triangle);

        // Store Rectangle and Adapter instances in a list
        List<RectInterface> rectangleObjects = new ArrayList<RectInterface>();
        rectangleObjects.add(rectangle);
        rectangleObjects.add(adapter);

        System.out.println("Processing the following objects:\n");

        // Iterate through the list and display the area of each object
        for(RectInterface rectObject : rectangleObjects){
            System.out.println("Area: " + getDetails(rectObject) + " square units.\n");
        }
    }


    static double getDetails(RectInterface rect){
        rect.aboutMe();
        return rect.calculateArea();
    }
}
