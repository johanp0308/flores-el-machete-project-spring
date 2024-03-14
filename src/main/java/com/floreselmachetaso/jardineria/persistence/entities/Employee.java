package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_code", nullable = false)
    private Integer employeeCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name1", nullable = false)
    private String lastName1;

    @Column(name = "last_name2")
    private String lastName2;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "office_code", nullable = false)
    private String officeCode;

    @ManyToOne
    @JoinColumn(name = "boss_code")
    private Employee boss;

    @Column(name = "job_title")
    private String jobTitle;
}
