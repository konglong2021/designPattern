package com.example.designpattern.adapter;

import com.example.designpattern.pattern.adapter.Apple;
import com.example.designpattern.pattern.adapter.AppleAdapter;
import com.example.designpattern.pattern.adapter.MoroOrange;
import com.example.designpattern.pattern.adapter.Orange;
import org.junit.jupiter.api.Test;

public class AppleAdapterTest {

    @Test
    public void testAppleAdapter(){
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }
}
