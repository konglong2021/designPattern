package com.example.designpattern.statemachine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "state_transitions")
public class StateTransition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String event;

    private String fromState;

    private String toState;

    @Column(name = "template_id", nullable = true)
    private String templateId;
}
