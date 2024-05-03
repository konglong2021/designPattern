package com.example.designpattern.database.controller;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee) {
        Employee optionalEmployee = employeeService.getEmployeeById(employeeId);
        if (optionalEmployee != null) {
            optionalEmployee.setFirstName(employee.getFirstName());
            optionalEmployee.setLastName(employee.getLastName());
            optionalEmployee.setEmail(employee.getEmail());
            Employee updatedEmployee = employeeService.updateEmployee(optionalEmployee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployee(id);
        }catch(Exception e){
            throw new RuntimeException("Employee with id " + id + " not found");
        }

    }
}
