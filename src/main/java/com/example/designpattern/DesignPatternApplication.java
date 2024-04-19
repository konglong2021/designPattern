package com.example.designpattern;


import com.example.designpattern.statemachine.config.Events;
import com.example.designpattern.statemachine.config.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.statemachine.StateMachine;

//@EnableScheduling
@SpringBootApplication
public class DesignPatternApplication implements CommandLineRunner{


    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

//    @Autowired
//    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
//        stateMachine.sendEvent(Events.E1);
//        stateMachine.sendEvent(Events.E2);
//        stateMachine.sendEvent(Events.E3);

    }

}
