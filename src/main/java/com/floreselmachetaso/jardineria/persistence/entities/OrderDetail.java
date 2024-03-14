package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK id;

    @ManyToOne
    @JoinColumn(name = "order_code", insertable = false, updatable = false)
    @MapsId("orderCode")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_code", insertable = false, updatable = false)
    @MapsId("productCode")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 15, scale = 2, nullable = false)
    private Double unitPrice;

    @Column(name = "line_number", nullable = false)
    private Short lineNumber;
}
