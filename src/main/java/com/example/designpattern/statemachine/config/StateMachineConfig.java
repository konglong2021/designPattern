package com.example.designpattern.statemachine.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;


//@Configuration
//@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.S1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal()
                    .source(States.S1).target(States.S2).event(Events.E1).guard(guard())
                    .and()
                .withInternal()
                    .source(States.S2).event(Events.E2).action(action())
                    .and()
                .withLocal()
                .source(States.S2).target(States.S3).event(Events.E3).guardExpression("true");
    }

    @Bean
    public Guard<States,Events> guard(){
        return new Guard<States, Events>() {
            @Override
            public boolean evaluate(StateContext<States, Events> stateContext) {
                return true;
            }
        };
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Bean
    public Action<States,Events> action(){
        return new Action<States, Events>() {
            @Override
            public void execute(StateContext<States, Events> stateContext) {
                System.out.println("This is action: "+ stateContext.getStateMachine().getState().getId());
            }
        };
    }
}

