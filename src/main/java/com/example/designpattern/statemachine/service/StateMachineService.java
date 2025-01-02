package com.example.designpattern.statemachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService {

//    @Autowired
//    private StateMachine<String, String> stateMachine;
//
//    public String getCurrentState() {
//        return stateMachine.getState().getId();
//    }
//
//    public String sendEvent(String event) {
//        stateMachine.sendEvent(event);
//        return stateMachine.getState().getId();
//    }
}
