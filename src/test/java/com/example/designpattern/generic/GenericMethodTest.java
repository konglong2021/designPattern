package com.example.designpattern.generic;

import com.example.designpattern.collections.generic.GenericMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericMethodTest {
    @Test
    public void testGenericMethod(){
        GenericMethod method = new GenericMethod();
        System.out.println("Item is returned: " + method.showItem(123));
    }

    @Test
    public void testGenericMethod2(){
        GenericMethod method = new GenericMethod();
        Integer[] nums = {1, 2, 3, 4};
        String[] names = {"Adam","Ana","Daniel","Kevin","michael"};
        method.showItem(nums);
    }

    @Test
    public void testGenericMethod3(){
        GenericMethod method = new GenericMethod();

        boolean falseResult = method.checkEquality(10,44);
        boolean trueResult = method.checkEquality(10.5,10.5);
        Assertions.assertFalse(falseResult);
        Assertions.assertTrue(trueResult);
    }
}
