package com.example.designpattern.statemachine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
