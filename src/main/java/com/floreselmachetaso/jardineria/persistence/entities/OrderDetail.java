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
}
