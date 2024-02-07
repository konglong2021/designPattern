package com.example.designpattern.pattern.decorator.implement4;

public class RamDecorator extends Accessory{
    public RamDecorator(PCDecorator pc, int size){
        super(pc);
        this.accessoryCost = ramSizePrice(size);
        System.out.println(" For a RAM,size " + size + "GB, you pay an extra $" + this.accessoryCost);
    }

    private double ramSizePrice(int size){
         return size * 25.50;
    }
    @Override
    public double getPrice(){
        return pc.getPrice() + accessoryCost;
    }
}
