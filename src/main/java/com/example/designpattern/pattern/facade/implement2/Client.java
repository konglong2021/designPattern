package com.example.designpattern.pattern.facade.implement2;

public class Client {
    public static void main(String[] args){
        System.out.println("***Simplifying the usage of a complex system using a facade***");
        RobotFacade milanoRobotFacade = new RobotFacade();
        milanoRobotFacade.constructMilanoRobot();
        RobotFacade robonautRobotFacade = new RobotFacade();
        robonautRobotFacade.constructRobonautRobot();
        milanoRobotFacade.destroyMilanoRobot();
        robonautRobotFacade.destroyRobonautRobot();
    }
}
