package com.example.designpattern.statemachine.repository;

import com.example.designpattern.statemachine.entity.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRepository extends JpaRepository<Transition, Long> {
}
