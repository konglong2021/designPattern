package com.example.designpattern.statemachine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transitions")
public class Transition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SourceState;
    private String TargetState;
    private String Event;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceState(String sourceState) {
        SourceState = sourceState;
    }

    public void setTargetState(String targetState) {
        TargetState = targetState;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public Long getId() {
        return id;
    }

    public String getSourceState() {
        return SourceState;
    }

    public String getTargetState() {
        return TargetState;
    }

    public String getEvent() {
        return Event;
    }
}
