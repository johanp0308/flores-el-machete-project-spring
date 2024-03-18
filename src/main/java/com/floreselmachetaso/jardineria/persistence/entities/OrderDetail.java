package com.floreselmachetaso.jardineria.persistence.entities;

import com.floreselmachetaso.jardineria.persistence.DTO.OrderDetailDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "detalle_pedido")

public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK id;

    @ManyToOne
    @JoinColumn(name = "codigo_pedido", insertable = false, updatable = false)
    @MapsId("orderCode")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", insertable = false, updatable = false)
    @MapsId("productCode")
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private Integer quantity;

    @Column(name = "precio_unidad", nullable = false)
    private Double unitPrice;

    @Column(name = "numero_linea", nullable = false)
    private Integer lineNumber;

    public OrderDetailPK getId() {
        return id;
    }

    public void setId(OrderDetailPK id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", lineNumber=" + lineNumber +
                '}';
    }

    public OrderDetailDTO toDTO() {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderCode(this.getOrder().getOrderCode());
        orderDetailDTO.setProduct(this.getProduct().getProductCode());
        orderDetailDTO.setQuantity(getQuantity());
        orderDetailDTO.setUnitPrice(getUnitPrice());
        orderDetailDTO.setLineNumber(getLineNumber());
        return orderDetailDTO;
    }

}
