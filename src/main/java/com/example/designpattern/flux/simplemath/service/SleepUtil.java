package com.example.designpattern.flux.simplemath.service;

public class SleepUtil {
    public static void sleepSecond(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
