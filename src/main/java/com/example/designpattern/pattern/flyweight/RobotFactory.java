package com.example.designpattern.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    static Map<String,Robot> robotFactory = new HashMap<String,Robot>();
    public int totalObjectsCreated()
    {
        return robotFactory.size();
    }

    public static synchronized Robot getRobotFromFactory(String robotType) throws Exception {
        Robot robotCategory = robotFactory.get(robotType);
        if(robotCategory == null)
        {
            switch (robotType)
            {
                case "small":
                    System.out.println("We do not have Small Robot at present. So we are creating a small robot now.");
                    robotCategory = new SmallRobot();
                    break;
                case "large":
                    System.out.println("We do not have Large Robot at present. So we are creating a large robot now.");
                    robotCategory = new LargeRobot();
                    break;
                case "fixed":
                    System.out.println("We do not have Fixed Size Robot at present. So we are creating a fixed size robot now.");
                    robotCategory = new FixedSizeRobot();
                    break;
                default:
                    throw new Exception(" Robot Factory can create only small, large and fixed size robots. ");
            }
            robotFactory.put(robotType,robotCategory);
        }else{
            System.out.print("\n \t Using existing robot " + robotType + " robot and coloring it");
        }
        return robotCategory;
    }
}
