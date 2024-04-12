package com.example.designpattern.repositorytest;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Save Employee")
    public void giveEmployeeObject_whenSave_thenReturnSaveEmployee() {
        //given     precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("tCjI8@example.com")
                .build();

        //when      action or behaviour that we are going to test
        Employee saveEmployee = employeeRepository.save(employee);

        //then      verifying the result
        assertThat(saveEmployee).isNotNull();
        assertThat(saveEmployee.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Save Multiple Employee")
    public void giveEmployeeObject_whenSave_thenReturnListEmployees(){
        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("tCjI8@example.com")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("Jane")
                .lastName("Ann")
                .email("E7D5q@example.com")
                .build();

        //when - action or the behaviour that we are going test
        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //then - verify the output
        assertThat(employeeRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Get Employee by email")
    public void giveEmployeeObject_whenFindByEmail_thenReturnEmployee(){
        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("tCjI8@example.com")
                .build();
        employeeRepository.save(employee);

        //when - action or the behaviour that we are going test
        Employee foundEmployee = employeeRepository.findByEmail(employee.getEmail());

        //then - verify the output
        assertThat(foundEmployee).isNotNull();
    }
}
