package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {
    @Id
    @Column(name = "codigo_oficina", nullable = false)
    private String codigoOficina;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "region")
    private String region;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "linea_direccion1", nullable = false)
    private String lineaDireccion1;

    @Column(name = "linea_direccion2")
    private String lineaDireccion2;
}
