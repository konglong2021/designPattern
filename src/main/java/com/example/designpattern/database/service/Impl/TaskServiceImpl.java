package com.example.designpattern.database.service.Impl;

import com.example.designpattern.database.entity.Task;
import com.example.designpattern.database.repository.TaskRepository;
import com.example.designpattern.database.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Autowired

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void completeTask(Long id) {
        Task task = getTask(id);
        if (task.getIsCompleted()) {
            throw new RuntimeException("Task already completed");
        }
        taskRepository.completeTask(id);
    }

    @Override
    public void reopenTask(Long id) {
        Task task = getTask(id);
        if (!task.getIsCompleted()) {
            throw new RuntimeException("Task already opened");
        }
        taskRepository.reopenTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getIncompleteTasks() {
        return taskRepository.getIncompleteTasks();
    }

    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.getCompletedTasks();
    }

    @Override
    public List<Task> getTasksByStatus(Integer status) {
        return taskRepository.getTasksByStatus(status);
    }

    @Override
    public List<Task> getTasksByEmployee(Long employeeId) {
        return taskRepository.getTasksByEmployeeId(employeeId);
    }
}
