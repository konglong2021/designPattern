package com.example.designpattern.pattern.decorator.implement4;

abstract class Accessory extends PCDecorator {
    protected PCDecorator pc;
    public double accessoryCost;
    public Accessory(PCDecorator pc){
        this.pc = pc;
    }

    @Override
    public double getPrice(){
        return pc.getPrice();
    }
}
