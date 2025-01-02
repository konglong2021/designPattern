package com.example.designpattern.statemachine.repository;

import com.example.designpattern.statemachine.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

}
