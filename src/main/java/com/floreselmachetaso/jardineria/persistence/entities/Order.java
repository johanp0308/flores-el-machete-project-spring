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
    @Column(name = "order_code", nullable = false)
    private Integer orderCode;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "expected_date", nullable = false)
    private Date expectedDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_code")
    private Customer customer;
}
