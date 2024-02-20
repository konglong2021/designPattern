package com.example.designpattern.pattern.composite.implement2;

public class Client {
    public static void main(String[] args) {
        Composite computer = new Composite("电脑");
        Equipment processor = new Equipment("处理器", 1000);
        Equipment hdd = new Equipment("硬盘", 200);
        Composite memory = new Composite("内存");
        Equipment rom = new Equipment("只读内存条", 50);
        Equipment ram = new Equipment("内存条", 100);

        memory.add(rom).add(ram);
        computer.add(processor).add(hdd).add(memory);
        System.out.println("电脑价格: " + computer.getPrice());
        System.out.println("内存价格: " + memory.getPrice());
    }
}
