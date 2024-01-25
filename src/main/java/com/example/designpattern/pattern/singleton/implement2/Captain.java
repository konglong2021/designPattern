package com.example.designpattern.pattern.singleton.implement2;

final class Captain {
    private static Captain captain;

    private Captain(){}
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
}
