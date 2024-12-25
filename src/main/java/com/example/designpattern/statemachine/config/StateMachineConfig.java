package com.example.designpattern.statemachine.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;


@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<States,Events>{

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
               .initial(States.CREATED)
               .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal().source(States.CREATED).target(States.PENDING_APPROVAL_1).event(Events.SUBMIT)
                .and()
                .withExternal().source(States.PENDING_APPROVAL_1).target(States.PENDING_APPROVAL_2).event(Events.APPROVE_1)
                .and()
                .withExternal().source(States.PENDING_APPROVAL_2).target(States.APPROVED).event(Events.APPROVE_2)
                .and()
                .withExternal().source(States.PENDING_APPROVAL_1).target(States.REJECTED).event(Events.REJECT)
                .and()
                .withExternal().source(States.PENDING_APPROVAL_2).target(States.REJECTED).event(Events.REJECT);
    }
}


