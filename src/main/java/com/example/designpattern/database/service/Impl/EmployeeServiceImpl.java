package com.example.designpattern.database.service.Impl;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
import com.example.designpattern.database.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (saveEmployee != null){
            throw new RuntimeException("Employee already existed by email : " + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }
}
