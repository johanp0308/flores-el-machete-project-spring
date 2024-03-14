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
    @Column(name = "codigo_empleado", nullable = false)
    private Integer employeeCode;

    @Column(name = "nombre", nullable = false)
    private String firstName;

    @Column(name = "apellido1", nullable = false)
    private String lastName1;

    @Column(name = "apellido2")
    private String lastName2;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "codigo_oficina", nullable = false)
    private String officeCode;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe ")
    private Employee boss;

    @Column(name = "puesto")
    private String jobTitle;
}
