package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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

    @Column(name = "puesto")
    private String jobTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_oficina")
    private Office office;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_jefe")
    private Employee boss;


    @OneToMany(mappedBy = "salesRepresentativeEmployee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customers;


}
