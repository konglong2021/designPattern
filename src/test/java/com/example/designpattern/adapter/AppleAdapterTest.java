package com.example.designpattern.adapter;

import com.example.designpattern.pattern.adapter.Apple;
import com.example.designpattern.pattern.adapter.AppleAdapter;
import com.example.designpattern.pattern.adapter.MoroOrange;
import com.example.designpattern.pattern.adapter.Orange;
import com.example.designpattern.pattern.adapter.implement1.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppleAdapterTest {

    @Test
    public void testAppleAdapter(){
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }

    @Test
    public void testAdapterPatternDemo() {
        RectInterface rectangle = new Rectangle(20, 10);
        TriInterface triangle = new Triangle(20, 10);
        RectInterface adapter = new Adapter(triangle);

        List<RectInterface> rectangleObjects = new ArrayList<>();
        rectangleObjects.add(rectangle);
        rectangleObjects.add(adapter);

        assertEquals(200, getArea(rectangleObjects.get(0)));
        assertEquals(100, getArea(rectangleObjects.get(1)));
    }

    static double getArea(RectInterface rect){
        rect.aboutMe();
        return rect.calculateArea();
    }
}
