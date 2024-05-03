package com.example.designpattern.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false,columnDefinition = "varchar(255)")
    private String firstName;
    @Column(name = "last_name",nullable = false,columnDefinition = "varchar(255)")
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "employee",cascade = {CascadeType.ALL})
    private List<Task> tasks ;

}
