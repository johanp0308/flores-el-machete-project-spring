package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import java.util.List;
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
    @Column(name = "gama", nullable = false)
    private String productLine;

    @Column(name = "descripcion_texto", columnDefinition = "TEXT")
    private String textDescription;

    @Column(name = "descripcion_html", columnDefinition = "TEXT")
    private String htmlDescription;

    @Column(name = "imagen")
    private String image;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productLine", cascade = CascadeType.ALL)
    private List<Product> products;
}
