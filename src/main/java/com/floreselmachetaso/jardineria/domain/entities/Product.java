package com.floreselmachetaso.jardineria.domain.entities;

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
    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLine productLine;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "quantity_in_stock", nullable = false)
    private Short quantityInStock;

    @Column(name = "sale_price", precision = 15, scale = 2, nullable = false)
    private Double salePrice;

    @Column(name = "supplier_price", precision = 15, scale = 2)
    private Double supplierPrice;
}
