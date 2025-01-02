package com.example.designpattern.statemachine.repository;

import com.example.designpattern.statemachine.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
