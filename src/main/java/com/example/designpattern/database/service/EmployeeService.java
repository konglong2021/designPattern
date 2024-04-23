package com.example.designpattern.database.service;


import com.example.designpattern.database.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
