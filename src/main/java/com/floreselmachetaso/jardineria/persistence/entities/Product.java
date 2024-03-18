package com.floreselmachetaso.jardineria.persistence.entities;

import com.floreselmachetaso.jardineria.persistence.DTO.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", salePrice=" + salePrice +
                ", supplierPrice=" + supplierPrice +
                ", productLine=" + productLine +
                '}';
    }

    public ProductDTO toProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode(this.productCode);
        productDTO.setName(this.name);
        productDTO.setProductLine(this.productLine.getProductLine());
        productDTO.setDimensions(this.dimensions);
        productDTO.setSupplier(this.supplier);
        productDTO.setDescription(this.description);
        productDTO.setQuantityInStock(this.quantityInStock);
        productDTO.setSalePrice(salePrice);
        productDTO.setSupplierPrice(supplierPrice);
        return productDTO;
    }
}
