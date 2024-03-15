package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente", nullable = false)
    private Integer customerCode;

    @Column(name = "nombre_cliente", nullable = false)
    private String customerName;

    @Column(name = "nombre_contacto")
    private String contactName;

    @Column(name = "apellido_contacto")
    private String contactLastName;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "fax", nullable = false)
    private String fax;

    @Column(name = "linea_direccion1", nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2")
    private String addressLine2;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String country;

    @Column(name = "codigo_postal")
    private String postalCode;

    @Column(name = "limite_credito")
    private Double creditLimit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Employee salesRepresentativeEmployee;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;

}
