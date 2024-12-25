package com.example.designpattern.database.repository;

import com.example.designpattern.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployeeId(Long employeeId);
    List<Task> findByStatus(Integer status);
    
    @Modifying
    @Query("UPDATE Task t SET t.isCompleted = true WHERE t.id = :id")
    void completeTask(@Param("id") Long id);
    
    @Modifying
    @Query("UPDATE Task t SET t.isCompleted = false WHERE t.id = :id")
    void reopenTask(@Param("id") Long id);
    
    List<Task> findAll();
    List<Task> findByIsCompletedFalse();
    List<Task> findByIsCompletedTrue();
}
