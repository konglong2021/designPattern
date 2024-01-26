package com.example.designpattern.decorator;

import com.example.designpattern.pattern.decorator.Pepperoni;
import com.example.designpattern.pattern.decorator.Pizza;
import com.example.designpattern.pattern.decorator.ThickCrustPizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DecoratorTest {

    @Test
    public void testDecorator(){
        Pizza pizza = new ThickCrustPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        Pepperoni pepperoni = new Pepperoni(pizza);
        System.out.println(pepperoni.getDescription());
        System.out.println(pepperoni.getCost());

        Pepperoni doublePepperoni = new Pepperoni(pepperoni);
        System.out.println(doublePepperoni.getDescription());
        System.out.println(doublePepperoni.getCost());

        Assertions.assertEquals(doublePepperoni.getCost(),(pepperoni.getCost() .add(new BigDecimal("1.50"))));
    }
}
