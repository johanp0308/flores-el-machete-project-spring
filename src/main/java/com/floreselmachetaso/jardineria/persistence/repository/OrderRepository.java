package com.floreselmachetaso.jardineria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.domain.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
