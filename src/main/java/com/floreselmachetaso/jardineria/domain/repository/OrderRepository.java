package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.persistence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
