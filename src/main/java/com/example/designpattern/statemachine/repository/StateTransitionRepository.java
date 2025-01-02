package com.example.designpattern.statemachine.repository;

import com.example.designpattern.statemachine.entity.StateTransition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateTransitionRepository extends JpaRepository<StateTransition, Long> {
    List<StateTransition> findByFromState(String fromState);
    List<StateTransition> findByTemplateId(String templateId);
}