package com.example.designpattern.database.repository;

import com.example.designpattern.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByEmployeeId(Long employeeId);
    List<Task> getTasksByStatus(Integer status) ;
    void completeTask(Long id);
    void reopenTask(Long id);
    List<Task> getAllTasks();
    List<Task> getIncompleteTasks();
    List<Task> getCompletedTasks();
}
