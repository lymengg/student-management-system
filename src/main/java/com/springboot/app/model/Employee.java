package com.springboot.app.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name= "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Id;
    @Column(name = "first_Name")
    public String firstName;
    @Column(name = "last_Name")
    public String lastName;
    @Column(name = "email")
    public String email;
}
