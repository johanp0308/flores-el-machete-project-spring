package com.floreselmachetaso.jardineria.domain.entities;

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
    @JoinColumn(name = "customer_code")
    private Customer customer;

    @Id
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "total_amount", precision = 15, scale = 2, nullable = false)
    private Double totalAmount;
}
