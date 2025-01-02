package com.example.designpattern.statemachine.controller;

import com.example.designpattern.statemachine.service.DynamicStateMachineService;
import com.example.designpattern.statemachine.service.StateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/state-machine")
public class StateMachineController {
//
//    @Autowired
//    private ExampleStateMachine exampleStateMachine;

//    @Autowired
//    private StateMachineService stateMachineService;

//    @PostMapping("/trigger")
//    public ResponseEntity<String> triggerEvent(@RequestParam String event) {
////        exampleStateMachine.runStateMachine();
//        String currentState = exampleStateMachine.sendEvent(event);
//        if (currentState == null)
//        {
//            return ResponseEntity.badRequest().body("Error: Invalid event: " + event);
//        }
//        return ResponseEntity.ok("Event triggered: " + currentState);
//    }

//    @GetMapping("/current-state")
//    public String getCurrentState(){
//        return stateMachineService.getCurrentState();
//    }
//
//    @PostMapping("/send-event")
//    public ResponseEntity<String> sendEvent(@RequestParam String event) {
//        String success = stateMachineService.sendEvent(event);
//        if (success == null)
//        {
//            return ResponseEntity.badRequest().body("Error: Invalid event: " + event);
//        }
//        return ResponseEntity.ok(STR."Event sent: \{event} Current State: \{stateMachineService.getCurrentState()}");
//    }

    @Autowired
    private DynamicStateMachineService stateMachineService;

    @GetMapping("/{templateId}")
    public ResponseEntity<String> initializeStateMachine(@PathVariable String templateId) {
        StateMachine<String, String> stateMachine = stateMachineService.createStateMachine(templateId);
        return ResponseEntity.ok("State Machine Initialized for Machine ID: " + templateId);
    }

    @GetMapping("/{templateId}/current-state")
    public ResponseEntity<String> getCurrentState(@PathVariable String templateId) {
        String currentState = stateMachineService.getCurrentState(templateId);
        return ResponseEntity.ok(STR."Current State: \{currentState}");
    }

    @GetMapping("/{templateId}/send-event/{event}")
    public ResponseEntity<String> getCurrentState(@PathVariable String templateId, @PathVariable String event) {
        String currentState = stateMachineService.sendEvent(templateId,event);
        return ResponseEntity.ok(STR."Current State: \{currentState}");
    }
}
