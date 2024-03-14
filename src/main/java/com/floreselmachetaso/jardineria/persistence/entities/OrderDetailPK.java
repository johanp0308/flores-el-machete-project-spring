package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_pedido")
    private Order orderCode;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Product productCode;
}
