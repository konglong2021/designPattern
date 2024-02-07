package com.example.designpattern.pattern.flyweight;

import java.util.Random;

public class FlyweightPatternExample {
    public static void main(String[] args) throws Exception {
        RobotFactory robotFactory = new RobotFactory();
        System.out.println("\n***Flyweight Pattern Example***\n");
        Robot myRobot;
        for (int i = 0; i< 3;i++){
            myRobot = RobotFactory.getRobotFromFactory("small");
            Thread.sleep(500);
            myRobot.showMe(getRandomColor());
        }
        int numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created = " + numOfDistinctRobots);
        for (int i = 0; i< 5; i++){
            myRobot = RobotFactory.getRobotFromFactory("large");
            Thread.sleep(500);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created = " + numOfDistinctRobots);
        for (int i = 0; i< 4; i++){
            myRobot = RobotFactory.getRobotFromFactory("fixed");
            Thread.sleep(500);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created = " + numOfDistinctRobots);
    }

    static String getRandomColor(){
        Random r = new Random();
        int random = r.nextInt();
        if (random % 2 == 0){
            return "red";
        }else{
            return "green";
        }
    }
}
