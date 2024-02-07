package com.example.designpattern.pattern.adapter.implement3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        System.out.println("***Adapter Pattern Demo.***");
        Rectangle rectangle = new Rectangle(20,10);
        System.out.println("Area of Rectangle is : "+rectangle.calculateAreaOfRectangle()+" square units.");
        Triangle triangle = new Triangle(10,5);
        System.out.println("Area of Triangle is : "+triangle.calculateAreaOfTriangle()+" square units.");
        RectInterface adapter = new TriangleAdapter(triangle);
        //Passing a Triangle instead of a Rectangle
        System.out.println("Area of Triangle using the triangle adapter is : "+getArea(adapter)+" square units.");
        List<RectInterface> rectangleObjects = new ArrayList<RectInterface>();
        rectangleObjects.add(rectangle);
        rectangleObjects.add(adapter);
        System.out.println("");
        System.out.println("*****Current objects in the system are:*****");
        for (RectInterface rectObjects:rectangleObjects)
        {
            rectObjects.aboutRectangle();
        }
    }

    static double getArea(RectInterface rect){
        return rect.calculateAreaOfRectangle();
    }
}
