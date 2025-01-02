package com.example.designpattern.statemachine;

import com.example.designpattern.DesignPatternApplication;
import com.example.designpattern.statemachine.config.Events;
import com.example.designpattern.statemachine.config.States;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.plaf.nimbus.State;

//@Service
public class ExampleStateMachine {

//    @Autowired
//    private StateMachine<States, Events> stateMachine;
//
////    @PostConstruct
////    public void initialInstance() {
////        if (stateMachine != null) {
////            stateMachine.startReactively().block();
////        } else {
////            throw new IllegalStateException("StateMachine is not initialized");
////        }
////    }
//
//
////    public static void main(String[] args) {
////        ConfigurableApplicationContext context = SpringApplication.run(DesignPatternApplication.class, args);
////        ExampleStateMachine exampleStateMachine = context.getBean(ExampleStateMachine.class);
////        exampleStateMachine.runStateMachine();
////}
//
//    public void runStateMachine() {
//        Mono.just(Events.SUBMIT)
//                .flatMap(this::sendEventAndPrintState)
//                .then(Mono.just(Events.APPROVE_1))
//                .flatMap(this::sendEventAndPrintState)
//                .then(Mono.just(Events.REJECT))
//                .flatMap(this::sendEventAndPrintState)
//                .then(Mono.just(Events.APPROVE_2))
//                .flatMap(this::sendEventAndPrintState)
//                .block();
//    }
//
//    public String sendEvent(String event) {
//        Events eventEnum;
//        try {
//            eventEnum = Events.valueOf(event);
//        } catch (IllegalArgumentException e) {
//            return "Error: Invalid event: " + event;
//        }
//
//        stateMachine.sendEvent(eventEnum);
//        States currentState = stateMachine.getState().getId();
//
//        return "Event sent: " + event + ". Current state: " + currentState;
//    }
//
//    private Mono<String> sendEventAndPrintState(Events event) {
//        return stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(event).build()))
//                .then(Mono.fromRunnable(() -> {
//                    States currentState = stateMachine.getState().getId();
//                    System.out.println("Event sent: " + event + ". Current state: " + currentState);
//                }));
//    }
}