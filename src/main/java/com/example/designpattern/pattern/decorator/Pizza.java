package com.example.designpattern.pattern.decorator;

import java.math.BigDecimal;

public abstract class Pizza {
    protected String description;

    public String getDescription(){
        return description;
    }

    public abstract BigDecimal getCost();
}
