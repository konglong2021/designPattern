package com.example.designpattern.pattern.decorator.implement4;

public class Client {
    public static void main(String[] args){
        System.out.println("***Using wrappers in different scenarios.***\n");
        System.out.println("Scenario-1: Making a basic pc with standard accessories.");
        PCDecorator pc = new BasicPc();
        System.out.println("Total cost: $" + pc.getPrice());
        System.out.println("\nScenario-2: Making a basic pc. Then adding a ram.");
        pc = new BasicPc();
        pc = new RamDecorator(pc,16);
        System.out.println("Total cost: $" + pc.getPrice());
        System.out.println("\nScenario-3: Making a basic pc. Then adding a vga.");
        pc = new BasicPc();
        pc = new VGADecorator(pc);
        System.out.println("Total cost: $" + pc.getPrice());
        System.out.println("\nScenario-4: Making a basic pc. Then adding a ram and vga.");
        pc = new BasicPc();
        pc = new RamDecorator(pc,32);
        pc = new VGADecorator(pc);
        System.out.println("Total cost: $" + pc.getPrice());
        System.out.println("\nScenario-5: Making an advanced pc now.");
        pc = new AdvancePC();
        System.out.println("Total cost: $" + pc.getPrice());
        System.out.println("\nScenario-6: Making an advanced pc. Then adding a ram.");
        pc = new AdvancePC();
        pc = new RamDecorator(pc,16);
        System.out.println("Total cost: $" + pc.getPrice());
    }
}
