package com.example.designpattern.statemachine.service;

import com.example.designpattern.statemachine.entity.StateTransition;
import com.example.designpattern.statemachine.repository.StateTransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.configurers.DefaultExternalTransitionConfigurer;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DynamicStateMachineService {

    @Autowired
    private StateTransitionRepository stateTransitionRepository;

    @Autowired
    private StateMachineFactory<String, String> stateMachineFactory;


    public StateMachine<String, String> createStateMachine(String templateId) {
        // Load transitions dynamically for the requested machine
        List<StateTransition> dbTransitions = stateTransitionRepository.findByTemplateId(templateId);
        Set<String> allStates = new HashSet<>();
    
        for (StateTransition transition : dbTransitions) {
            allStates.add(transition.getFromState());
            allStates.add(transition.getToState());
        }
    
        // Create a new state machine instance
        StateMachine<String, String> stateMachine = stateMachineFactory.getStateMachine(templateId);
        stateMachine.stop();
    
        // Configure states and transitions dynamically
        try {
            stateMachine.getStateMachineAccessor()
                    .doWithAllRegions(accessor -> {
                        // Reset the state machine to the initial state
                        accessor.resetStateMachine(
                                new DefaultStateMachineContext<>("manager_approve", null, null, null));
                    });
        } catch (Exception e) {
            throw new RuntimeException("Error configuring state machine", e);
        }
    
        stateMachine.start();
    
        return stateMachine;
    }


    
    // ...
    
    public StateMachine<String, String> createStateMachine(String documentId, List<String> approvers) throws Exception {
        // Initialize the StateMachineBuilder
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();
    
        // Configure states
        builder.configureStates()
                .withStates()
                .initial("START")
                .end("END")
                .states(Set.copyOf(approvers)); // Add all approvers as states
    
        // Configure transitions
        StateMachineTransitionConfigurer<String, String> transitions = builder.configureTransitions();
    
        for (int i = 0; i < approvers.size(); i++) {
            String fromState = i == 0 ? "START" : approvers.get(i - 1);
            String toState = approvers.get(i);
            String event = "APPROVE_" + toState.toUpperCase();
    
            transitions.withExternal()
                    .source(fromState)
                    .target(toState)
                    .event(event);
        }
    
        // Transition to END after the last approver
        String lastApprover = approvers.get(approvers.size() - 1);
        transitions.withExternal()
                .source(lastApprover)
                .target("END")
                .event("COMPLETE");
    
        // Build the state machine
        return builder.build();
    }

    public String getCurrentState(String templateId) {
        StateMachine<String, String> stateMachine = createStateMachine(templateId);
        return stateMachine.getState().getId();
    }

    public String sendEvent(String templateId,String event) {
        StateMachine<String, String> stateMachine = createStateMachine(templateId);
        stateMachine.sendEvent(event);
        return stateMachine.getState().getId();
    }
}
