package com.example.designpattern.service;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(null);
        given(employeeRepository.save(employee)).willReturn(employee);

        //when - action or the behaviour that we are going test
        Employee saveEmployee = employeeService.saveEmployee(employee);

        //then - verify the output
        assertThat(saveEmployee).isNotNull();
    }

    @Test
    @DisplayName("Test for save existed employee method")
    public void giveEmployeeExistedObject_whenSave_thenThrowException(){
        //given - precondition or setup
        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(employee);
       // BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        //when - action or the behaviour that we are going test
        assertThrows(RuntimeException.class,() -> {
            employeeService.saveEmployee(employee);
        });
        //Employee saveEmployee = employeeService.saveEmployee(employee);

        //then - verify the output
        //Assertions.assertThat(saveEmployee).isNotNull();
        verify(employeeRepository,Mockito.never()).save(Mockito.any(Employee.class));
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

    @Test
    public void giveEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject(){
        //given - precondition or setup
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        //when - action or the behaviour that we are going test
        Employee saveEmployee = employeeService.getEmployeeById(employee.getId());

        //then - verify the output
        assertThat(saveEmployee).isNotNull();
    }

    @Test
    void testUpdateEmployee_happyPath() {
        // Given
        Employee employee = new Employee();
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        // When
        Employee result = employeeService.updateEmployee(employee);

        // Then
        assertEquals(employee, result);
    }

    @DisplayName("Test for delete employee method with valid id")
    @Test
    void givenEmployeeId_whenDeleteEmployee_thenVerifySuccess() {
        // Given
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        // When
        employeeService.deleteEmployee(employee.getId());

        // Then
        verify(employeeRepository, times(1)).deleteById(employee.getId());

    }


   @DisplayName("Test for delete employee method with null id")
    @Test
    void testDeleteEmployee_edgeCase_negativeId() {
        // Given
        Long id = -1L;

        // When
        // id is null or -1, then it will throw runtime exception
        assertThrows(RuntimeException.class,() -> {
            employeeService.deleteEmployee(id);
        });

        // Then
        verify(employeeRepository, times(0)).deleteById(id);
    }

    @DisplayName("Test for delete employee method with null id")
    @Test
    void testDeleteEmployee_edgeCase_nullId() {
        // Given
        Long id = null;

        // When
        // id is null or -1, then it will throw runtime exception
        assertThrows(RuntimeException.class,() -> {
            employeeService.deleteEmployee(id);
        });

        // Then
        verify(employeeRepository, times(0)).deleteById(id);
    }


    @DisplayName("Test for update existed employee and return updated employee")
    @Test
    public void giveEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){
        //given - precondition or setup
        given(employeeRepository.save(employee)).willReturn(employee);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("johndoe@gmail.com");

        //when - action or the behaviour that we are going test
        Employee updatedEmployee = employeeService.updateEmployee(employee);


        //then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("johndoe@gmail.com");
        assertThat(updatedEmployee.getLastName()).isEqualTo("Doe");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("John");
    }
}
