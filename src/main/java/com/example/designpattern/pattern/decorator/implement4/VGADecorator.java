package com.example.designpattern.pattern.decorator.implement4;

public class VGADecorator  extends Accessory{
    public VGADecorator(PCDecorator pc){
        super(pc);
        this.accessoryCost = 1000.0;
        System.out.println(" For a VGA, you pay an extra $" + this.accessoryCost);
    }

    @Override
    public double getPrice(){
        return pc.getPrice() + accessoryCost;
    }
}
