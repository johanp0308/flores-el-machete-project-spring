package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "codigo_producto", nullable = false)
    private String productCode;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "dimensiones")
    private String dimensions;

    @Column(name = "proveedor")
    private String supplier;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;

    @Column(name = "cantidad_en_stock", nullable = false)
    private Short quantityInStock;

    @Column(name = "precio_venta",nullable = false)
    private Double salePrice;

    @Column(name = "precio_proveedor")
    private Double supplierPrice;

    @ManyToOne
    @JoinColumn(name = "gama", nullable = false)
    private ProductLine productLine;

}
