package com.floreselmachetaso.jardineria.domain.entities;

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
    @JoinColumn(name = "order_code")
    private Order orderCode;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product productCode;
}
