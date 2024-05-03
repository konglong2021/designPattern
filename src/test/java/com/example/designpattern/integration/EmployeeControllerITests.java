package com.example.designpattern.integration;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerITests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();
    }

    @DisplayName("Test Create Employee API")
    @Test
    public void giveEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@example.com")
                .build();


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
        Employee employee = Employee.builder().firstName("Jon").lastName("Doe").email("johndoe@example.com").build();
        employeeRepository.save(employee);

        //when - action or the behaviour that we are going test
        ResultActions resultActions = mockMvc.perform(get("/api/employees/"+ employee.getId())
                .contentType(MediaType.APPLICATION_JSON));

        //then - verify the output
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));
    }

}
