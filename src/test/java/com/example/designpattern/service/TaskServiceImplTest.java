package com.example.designpattern.service;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.designpattern.database.entity.Employee;
import com.example.designpattern.database.entity.Task;
import com.example.designpattern.database.repository.TaskRepository;
import com.example.designpattern.database.service.Impl.TaskServiceImpl;
import com.example.designpattern.database.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.stubbing.answers.DoesNothing;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;
    private Employee employee;
    private Task task;
    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskServiceImpl(taskRepository);
        employee = Employee.builder()
                .id(1L)
                .firstName("Ly")
                .lastName("Konglong")
                .email("lykonglong@yahoo.com")
                .build();

        Long id = 1L;
        Task task = Task.builder()
                .id(id)
                .status(0)
                .title("Sample Title")
                .description("Sample Description")
                .employee(employee)
                .dueDate("2022-01-01")
                .priority(1)
                .isCompleted(false)
                .IsImportant(false)
                .build();
    }

    @Test
    void testCreateTask() {
        when(taskRepository.save(task)).thenReturn(task);

        Task createdTask = taskService.createTask(task);

        assertEquals(task, createdTask);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testGetTask() {
        Long id = 1L;

        when(taskRepository.findById(id)).thenReturn(Optional.ofNullable(task));

        Task retrievedTask = taskService.getTask(id);

        assertEquals(task, retrievedTask);
    }

    @Test
    void testDeleteTask() {
        Long id = 1L;
        taskService.deleteTask(id);

        verify(taskRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        when(taskRepository.save(task)).thenReturn(task);

        Task updatedTask = taskService.updateTask(task);

        assertEquals(task, updatedTask);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testCompleteTask() {
        Long id = 1L;
        Task task = Task.builder()
                .id(id)
                .status(0)
                .title("Sample Title")
                .description("Sample Description")
                .employee(employee)
                .dueDate("2022-01-01")
                .priority(1)
                .isCompleted(false)
                .IsImportant(false)
                .build();


        BDDMockito.given(taskRepository.findById(1L)).willReturn(Optional.ofNullable(task));
        taskService.completeTask(id);

        verify(taskRepository, times(1)).completeTask(id);
    }

    @Test
    void testReopenTask() {
        Long id = 1L;
        Task task = Task.builder()
                .id(id)
                .status(0)
                .title("Sample Title")
                .description("Sample Description")
                .employee(employee)
                .dueDate("2022-01-01")
                .priority(1)
                .isCompleted(true)
                .IsImportant(false)
                .build();
        //mock taskrepository.reopenTask(id) and does nothing
        //because we don't want to test the implementation of reopenTask
        //but only the interaction with the repository
        BDDMockito.given(taskRepository.findById(1L)).willReturn(Optional.ofNullable(task));
        taskService.reopenTask(id);

        verify(taskRepository, times(1)).reopenTask(id);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Collections.singletonList(new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(tasks, result);
    }

    @Test
    void testGetIncompleteTasks() {
        List<Task> incompleteTasks = Collections.singletonList(new Task());
        when(taskRepository.getIncompleteTasks()).thenReturn(incompleteTasks);

        List<Task> result = taskService.getIncompleteTasks();

        assertEquals(incompleteTasks, result);
    }

    @Test
    void testGetCompletedTasks() {
        List<Task> completedTasks = Collections.singletonList(new Task());
        when(taskRepository.getCompletedTasks()).thenReturn(completedTasks);

        List<Task> result = taskService.getCompletedTasks();

        assertEquals(completedTasks, result);
    }

    @Test
    void testGetTasksByStatus() {
        Integer status = 1;
        List<Task> tasks = Collections.singletonList(new Task());
        when(taskRepository.getTasksByStatus(status)).thenReturn(tasks);

        List<Task> result = taskService.getTasksByStatus(status);

        assertEquals(tasks, result);
    }

    @Test
    void testGetTasksByEmployee() {
        Long employeeId = 1L;
        List<Task> tasks = Collections.singletonList(new Task());
        when(taskRepository.getTasksByEmployeeId(employeeId)).thenReturn(tasks);

        List<Task> result = taskService.getTasksByEmployee(employeeId);

        assertEquals(tasks, result);
    }
}
