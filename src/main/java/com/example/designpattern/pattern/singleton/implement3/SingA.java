package com.example.designpattern.pattern.singleton.implement3;

public class SingA {
    private static SingA instance;
    //Implement in Test
    private SingA(){
        super();
    }

    public static SingA getInstance(){
        if (null == instance){
            synchronized (SingA.class){
                if (null == instance){
                    instance = new SingA();
                }
            }
        }
        return instance;
    }
}
