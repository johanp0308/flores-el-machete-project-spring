package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class OrderDetailPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_pedido")
    private Order orderCode;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Product productCode;

    public Order getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Order orderCode) {
        this.orderCode = orderCode;
    }

    public Product getProductCode() {
        return productCode;
    }

    public void setProductCode(Product productCode) {
        this.productCode = productCode;
    }
}
