package com.example.designpattern.pattern.singleton.implement1;

public class MakeACaptain {
    private static MakeACaptain _captain;
    private MakeACaptain(){}

    public static MakeACaptain getCaptain(){
        if(_captain == null){
            _captain = new MakeACaptain();
            System.out.println("New Captain selected for our team.");
        }else {
            System.out.print("You already have a Captain for your team.");
            System.out.println("Send him for the toss.");
        }
        return _captain;
    }
}
