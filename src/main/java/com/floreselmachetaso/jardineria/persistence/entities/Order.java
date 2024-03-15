package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "codigo_pedido")
    private Integer orderCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_esperada", nullable = false)
    private Date expectedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date deliverDate;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Customer customer;

}
