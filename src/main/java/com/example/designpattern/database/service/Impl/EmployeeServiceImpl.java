package com.example.designpattern.database.service.Impl;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
import com.example.designpattern.database.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

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

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee updateEmployee) {
        return employeeRepository.save(updateEmployee );
    }

    @Override
    public void deleteEmployee(Long id) {
        //if id is null, it will throw an exception
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new RuntimeException("Employee not found by id : " + id);
        }

        employeeRepository.deleteById(id);
    }
}
