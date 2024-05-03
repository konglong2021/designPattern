package com.example.designpattern.database.service;

import com.example.designpattern.database.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    Task getTask(Long id);
    void deleteTask(Long id);
    Task updateTask(Task task);
    void completeTask(Long id);
    void reopenTask(Long id);
    List<Task> getAllTasks();
    List<Task> getIncompleteTasks();
    List<Task> getCompletedTasks();
    List<Task> getTasksByStatus(Integer status);
    List<Task> getTasksByEmployee(Long employeeId);
}
