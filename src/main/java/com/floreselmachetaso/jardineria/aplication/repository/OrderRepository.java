package com.floreselmachetaso.jardineria.aplication.repository;

import com.floreselmachetaso.jardineria.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
