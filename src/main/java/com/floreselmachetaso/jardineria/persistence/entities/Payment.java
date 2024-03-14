package com.floreselmachetaso.jardineria.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Customer customer;

    @Id
    @Column(name = "id_transaccion ", nullable = false)
    private String transactionId;

    @Column(name = "forma_pago", nullable = false)
    private String paymentMethod;

    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", precision = 15, scale = 2, nullable = false)
    private Double totalAmount;
}
