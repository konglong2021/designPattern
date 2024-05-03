package com.example.designpattern.database.repository;

import com.example.designpattern.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee> {
    Employee findByEmail(String email);
}
