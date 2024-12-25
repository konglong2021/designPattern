package com.example.designpattern;

import com.example.designpattern.statemachine.config.Events;
import com.example.designpattern.statemachine.config.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DesignPatternApplication implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.startReactively().block();

        Mono.just(Events.SUBMIT)
            .flatMap(this::sendEventAndPrintState)
            .then(Mono.just(Events.APPROVE_1))
            .flatMap(this::sendEventAndPrintState)
            .then(Mono.just(Events.REJECT))
            .flatMap(this::sendEventAndPrintState)
            .then(Mono.just(Events.APPROVE_2))
            .flatMap(this::sendEventAndPrintState)

            .block();
    }

    private Mono<Void> sendEventAndPrintState(Events event) {
        return stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(event).build()))
            .then(Mono.fromRunnable(() -> {
                States currentState = stateMachine.getState().getId();
                System.out.println(STR."Event sent: \{event}. Current state: \{currentState}");
            }));
    }
}