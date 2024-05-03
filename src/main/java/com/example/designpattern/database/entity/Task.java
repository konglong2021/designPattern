package com.example.designpattern.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@ToString
@Table(name = "tasks")
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String dueDate;
    private Integer priority;
    private Integer status;
    private Boolean IsImportant;
    private Boolean isCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    @ToString.Exclude
    private Employee employee;
}
