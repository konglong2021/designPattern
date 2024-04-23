package com.example.designpattern.controller;

import com.example.designpattern.database.controller.EmployeeController;
import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.service.Impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class) //use webMvcTest need to specify the controller class to test
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Test Create Employee API")
    @Test
    public void giveEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@example.com")
                .build();

        BDDMockito.given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));

        //then - verify the output
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));

    }

    @DisplayName("Test Get Employee By Id API")
    @Test
    public void giveEmployee_whenGetEmployeeById_thenReturnEmployee() throws Exception {
        //given - precondition or setup
        Employee employee = Employee.builder().firstName("Jonh").lastName("Doe").email("johndoe@example.com").build();
        BDDMockito.given(employeeService.getEmployeeById(ArgumentMatchers.anyLong())).willAnswer((invocation) -> employee);

        //when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(get("/api/employees/1")
                .contentType(MediaType.APPLICATION_JSON));

        //then - verify the output
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));
    }

    @DisplayName("Test Update Employee API - positive scenario")
    @Test
    public void giveEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() throws Exception {
        //given - precondition or setup
        Long employeeId = 1L;
        Employee employee = Employee.builder().firstName("John").lastName("Doe").email("johndoe@example.com").build();
        Employee updatedEmployee = Employee.builder().firstName("Jane").lastName("Doe").email("janedoe@example.com").build();
        BDDMockito.given(employeeService.getEmployeeById(employeeId)).willReturn(employee);
        BDDMockito.given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        //then - verify the output
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(updatedEmployee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(updatedEmployee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(updatedEmployee.getEmail())));
    }

    @DisplayName("Test Update Employee API - negative scenario - employee not found")
    @Test
    public void giveUpdatedEmployee_whenUpdateEmployee_thenReturn404() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        Employee savedEmployee = Employee.builder().firstName("John").lastName("Doe").email("johndoe@example.com").build();
        Employee updatedEmployee = Employee.builder().firstName("Jane").lastName("Doe").email("janedoe@example.com").build();
        BDDMockito.given(employeeService.getEmployeeById(employeeId)).willReturn(null);
        BDDMockito.given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        //then - verify the output
        resultActions.andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("Test Delete Employee API - positive scenario")
    @Test
    public void giveEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        willDoNothing().given(employeeService).deleteEmployee(employeeId);

        //when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(delete("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON));

        //then - verify the output
        resultActions.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("Test Delete Employee API - negative scenario - employee not found")
    @Test
    public void giveEmployeeId_whenDeleteEmployee_thenReturn404() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        doThrow(new RuntimeException("Employee with id " + employeeId + " not found")).when(employeeService).deleteEmployee(employeeId);

        //when - action or the behaviour that we are going test
        RuntimeException exception = assertThrows(RuntimeException.class, () -> employeeController.deleteEmployee(employeeId));
        assertEquals("Employee with id 1 not found", exception.getMessage());

        //then - verify the output
        verify(employeeService, times(0)).deleteEmployee(employeeId);

    }


}
