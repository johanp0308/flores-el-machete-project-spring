package com.floreselmachetaso.jardineria.persistence.entities;

import com.floreselmachetaso.jardineria.persistence.DTO.ProductLineDTO;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "gama_producto")

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

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image='" + image + '\'' +
                ", products=" + products +
                '}';
    }

    public ProductLineDTO toDTO(){
        ProductLineDTO productLineDTO = new ProductLineDTO();
        productLineDTO.setProductLine(this.productLine);
        productLineDTO.setTextDescription(this.textDescription);
        productLineDTO.setHtmlDescription(this.htmlDescription);
        productLineDTO.setImage(this.image);
        return productLineDTO;
    }
}
