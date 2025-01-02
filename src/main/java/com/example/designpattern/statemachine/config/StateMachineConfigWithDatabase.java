package com.example.designpattern.statemachine.config;

import com.example.designpattern.statemachine.entity.StateTransition;
import com.example.designpattern.statemachine.repository.EventRepository;
import com.example.designpattern.statemachine.repository.StateRepository;
import com.example.designpattern.statemachine.repository.StateTransitionRepository;
import com.example.designpattern.statemachine.repository.TransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.*;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
//@EnableStateMachine
@EnableStateMachineFactory
public class StateMachineConfigWithDatabase extends StateMachineConfigurerAdapter<String,String> {

//    @Autowired
//    private StateRepository stateRepository;
//    @Autowired
//    private EventRepository eventRepository;
//    @Autowired
//    private TransitionRepository transitionRepository;
    @Autowired
    private StateTransitionRepository stateTransitionRepository;

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(false)
                .listener(listener());
    }

//    @Override
//    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
//        List<StateTransition> transitions = stateTransitionRepository != null ? stateTransitionRepository.findAll() : new ArrayList<>();
//        Set<String> allStates = new HashSet<>();
//
//        for (StateTransition transition : transitions) {
//            allStates.add(transition.getFromState());
//            allStates.add(transition.getToState());
//        }
//
//        states.withStates()
//                .initial("manager_approve")
//                .states(allStates);
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
//        List<StateTransition> dbTransitions = stateTransitionRepository.findAll();
//
//        for (StateTransition transition : dbTransitions) {
//            transitions
//                    .withExternal()
//                    .source(transition.getFromState())
//                    .target(transition.getToState())
//                    .event(transition.getEvent());
//        }
//    }

    @Bean
    public StateMachineListener<String, String> listener() {
        return new StateMachineListenerAdapter<String, String>() {
            @Override
            public void stateChanged(State<String, String> from, State<String, String> to) {
                //Logic to save current state to database
                System.out.println("State change to " + to.getId());
            }
        };
    }

}
