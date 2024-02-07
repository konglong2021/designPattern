package com.example.designpattern.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayEX {
    public static void main(String[] args) {
//        php array
//        $array['one'] = "one" ;
//        $array['two'] = "two" ;

        Map<String, String> map = new HashMap<>();
        map.put("one", "one");
        map.put("two", "two");

        // Access values using keys
        String valueOne = map.get("one");
        String valueTwo = map.get("two");

        //Display the values
        System.out.println(valueOne);
        System.out.println(valueTwo);

        if (map.containsKey("one")) {
            System.out.println("Key one exists");
        }

        if (map.containsKey("three")) {
            System.out.println("Key three exists");
        }
    }
}
