package com.floreselmachetaso.jardineria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.domain.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
