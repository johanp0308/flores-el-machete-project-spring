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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido", nullable = false)
    private Integer orderCode;

    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Column(name = "fecha_esperada", nullable = false)
    private Date expectedDate;

    @Column(name = "fecha_entrega")
    private Date deliveryDate;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Customer customer;
}
