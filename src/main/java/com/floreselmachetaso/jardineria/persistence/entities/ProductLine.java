package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gama_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine {

    @Id
    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "text_description", columnDefinition = "TEXT")
    private String textDescription;

    @Column(name = "html_description", columnDefinition = "TEXT")
    private String htmlDescription;

    @Column(name = "image", length = 256)
    private String image;
}
