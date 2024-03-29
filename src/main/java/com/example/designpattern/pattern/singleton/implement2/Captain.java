package com.example.designpattern.pattern.singleton.implement2;

class Captain {
    private static Captain captain;
    static int numberOfInstance = 0;

    private Captain(){
        numberOfInstance++;
        System.out.println("Number of instances at this moment = " + numberOfInstance);
    }
    public static synchronized Captain getCaptain(){
        if (captain == null){
            captain = new Captain();
            System.out.println("\tA new captain selected for our team.");
        }else {
            System.out.print("\tYou already have a Captain for your team.");
            System.out.println("\tSend him for the toss.");
        }
        return captain;
    }

    public class CaptainDerived extends Captain{
        public CaptainDerived(){
            numberOfInstance++;
            System.out.println("Sub Class Number of instances at this moment = " + numberOfInstance);
        }
    }
}
