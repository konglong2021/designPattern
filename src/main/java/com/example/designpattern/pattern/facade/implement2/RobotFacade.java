package com.example.designpattern.pattern.facade.implement2;

public class RobotFacade {
    RobotColor rColor;
    RobotHands rHands;
    RobotBody rBody;
    public RobotFacade(){
        rColor = new RobotColor();
        rHands = new RobotHands();
        rBody = new RobotBody();
    }

    public void constructMilanoRobot(){
        RobotBody.createRobot();
        System.out.println("Creation of a Milano Robot Start.");
        rColor.setDefaultColor();
        rHands.setMilanoHands();
        rBody.createHands();
        rBody.createRemainingParts();
        System.out.println(" Milano Robot Created.");
        System.out.println();
    }

    public void constructRobonautRobot(){
        RobotBody.createRobot();
        System.out.println("Initiating the creational process of a Robonaut Robot.");
        rColor.setGreenColor();
        rHands.setRobonautHands();
        rBody.createHands();
        rBody.createRemainingParts();
        System.out.println("A Robonaut Robot Created.");
        System.out.println();
    }

    public void destroyMilanoRobot(){
        RobotBody.destroyRobot();
        System.out.println(" Milano Robot's destruction process is started.");
        rHands.resetMilanoHands();
        rBody.destroyHands();
        rBody.destroyRemainingParts();
        System.out.println(" Milano Robot's destruction process is completed.");
        System.out.println();
    }

    public void destroyRobonautRobot(){
        RobotBody.destroyRobot();
        System.out.println(" Initiating a Robonaut Robot's destruction process.");
        rHands.resetRobonautHands();
        rBody.destroyHands();
        rBody.destroyRemainingParts();
        System.out.println(" A Robonaut Robot's is destroyed.");
        System.out.println();
    }
}
