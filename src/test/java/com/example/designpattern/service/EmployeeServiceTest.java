package com.example.designpattern.service;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
import com.example.designpattern.database.service.EmployeeService;
import com.example.designpattern.database.service.Impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
//    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    public void setup()
    {
//        employeeRepository = Mockito.mock(EmployeeRepository.class);
//        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = Employee.builder()
                .id(1L)
                .firstName("Ly")
                .lastName("Konglong")
                .email("lykonglong@yahoo.com")
                .build();
    }

    @Test
    @DisplayName("Test for save Employee Method")
    public void giveEmployeeObject_whenSave_thenReturnEmployeeObject(){
        //given - precondition or setup
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(null);
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        //when - action or the behaviour that we are going test
        Employee saveEmployee = employeeService.saveEmployee(employee);

        //then - verify the output
        Assertions.assertThat(saveEmployee).isNotNull();
    }

    @Test
    @DisplayName("Test for save existed employee method")
    public void giveEmployeeExistedObject_whenSave_thenThrowException(){
        //given - precondition or setup
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(employee);
       // BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        //when - action or the behaviour that we are going test
        assertThrows(RuntimeException.class,() -> {
            employeeService.saveEmployee(employee);
        });
        //Employee saveEmployee = employeeService.saveEmployee(employee);

        //then - verify the output
        //Assertions.assertThat(saveEmployee).isNotNull();
        Mockito.verify(employeeRepository,Mockito.never()).save(Mockito.any(Employee.class));
    }

    @Test
    void testSaveEmployeeHappyPath() {
        when(employeeRepository.findByEmail("lykonglong@yahoo.com")).thenReturn(null);
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("Konglong", savedEmployee.getLastName());
        assertEquals("lykonglong@yahoo.com", savedEmployee.getEmail());
    }

    @Test
    void testSaveEmployeeWithExistingEmail() {
        Employee existingEmployee = Employee.builder()
                .id(1L)
                .firstName("Existing")
                .lastName("Employee")
                .email("lykonglong@yahoo.com")
                .build();

        when(employeeRepository.findByEmail("lykonglong@yahoo.com")).thenReturn(existingEmployee);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            employeeService.saveEmployee(employee);
        });

        assertEquals("Employee already existed by email : lykonglong@yahoo.com", exception.getMessage());
    }
}
