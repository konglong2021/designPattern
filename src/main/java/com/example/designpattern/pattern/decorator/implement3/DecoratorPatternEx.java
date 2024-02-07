package com.example.designpattern.pattern.decorator.implement3;

public class DecoratorPatternEx {
    public static void main(String[] args) {
        ConcreteComponent cc = new ConcreteComponent();
        ConcreteDecoratorEx_1 cd1 = new ConcreteDecoratorEx_1();
        cd1.SetTheComponent(cc);
        cd1.doJob();

        System.out.println("____________________________");
        ConcreteDecoratorEx_2 cd2 = new ConcreteDecoratorEx_2();
        cd2.SetTheComponent(cd1);
        cd2.doJob();
    }
}
