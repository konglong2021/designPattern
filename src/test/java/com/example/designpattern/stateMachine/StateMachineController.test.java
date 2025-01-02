package com.example.designpattern.stateMachine;

import com.example.designpattern.statemachine.ExampleStateMachine;
import com.example.designpattern.statemachine.controller.StateMachineController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StateMachineControllerTest {

    @Mock
    private ExampleStateMachine exampleStateMachine;

    @InjectMocks
    private StateMachineController stateMachineController;

    @Test
    void shouldReturnEventTriggeredStateNameWhenValidEventIsTriggered() {
        // given
        String event = "VALID_EVENT";
        String expectedStateName = "STATE_NAME";
        when(exampleStateMachine.sendEvent(event)).thenReturn(expectedStateName);

        // when
        ResponseEntity<String> responseEntity = stateMachineController.triggerEvent(event);

        // then
        assertEquals("Event triggered: " + expectedStateName, responseEntity.getBody());
    }
    
    @Test
    void shouldReturnEventTriggeredStateNameWhenMultipleValidEventsAreTriggeredInSequence() {
        // given
        String[] events = { "VALID_EVENT_1", "VALID_EVENT_2", "VALID_EVENT_3" };
        String[] expectedStateNames = { "STATE_NAME_1", "STATE_NAME_2", "STATE_NAME_3" };
    
        // when
        for (int i = 0; i < events.length; i++) {
            when(exampleStateMachine.sendEvent(events[i])).thenReturn(expectedStateNames[i]);
            ResponseEntity<String> responseEntity = stateMachineController.triggerEvent(events[i]);
    
            // then
            assertEquals("Event triggered: " + expectedStateNames[i], responseEntity.getBody());
        }
    }

    @Test
    void shouldReturnErrorMessageWhenInvalidEventIsTriggered() {
        // given
        String invalidEvent = "INVALID_EVENT";
        String expectedErrorMessage = "Invalid event: " + invalidEvent;
        when(exampleStateMachine.sendEvent(invalidEvent)).thenReturn(null);
    
        // when
        ResponseEntity<String> responseEntity = stateMachineController.triggerEvent(invalidEvent);
    
        // then
        assertEquals("Error: " + expectedErrorMessage, responseEntity.getBody());
    }
    
    @Test
    void shouldHandleConcurrentRequestsAndMaintainStateConsistency() {
        // given
        String[] events = { "VALID_EVENT_1", "VALID_EVENT_2", "VALID_EVENT_3" };
        String[] expectedStateNames = { "STATE_NAME_1", "STATE_NAME_2", "STATE_NAME_3" };
        CountDownLatch latch = new CountDownLatch(events.length);

        // when
        for (String event : events) {
            Mono.fromRunnable(() -> {
                String currentState = exampleStateMachine.sendEvent(event);
                assertEquals(STR."Event triggered: \{expectedStateNames[(int) latch.getCount()]}", currentState);
                latch.countDown();
            }).subscribe();
        }

        // then
        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            fail("Interrupted while waiting for concurrent requests to finish");
        }
    }
    @Test
    void shouldHandleStateTransitionsWithComplexConditions() {
        // given
        String complexEvent = "COMPLEX_EVENT";
        String expectedStateName = "COMPLEX_STATE";
        when(exampleStateMachine.sendEvent(complexEvent)).thenReturn(expectedStateName);

        // when
        ResponseEntity<String> responseEntity = stateMachineController.triggerEvent(complexEvent);

        // then
        assertEquals("Event triggered: " + expectedStateName, responseEntity.getBody());
    }

}