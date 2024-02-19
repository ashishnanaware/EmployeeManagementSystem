package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @Column(unique = true)
    private String phone;
    private String email;
    private int sal;
    @Transient
    private Addresses addresses;
}