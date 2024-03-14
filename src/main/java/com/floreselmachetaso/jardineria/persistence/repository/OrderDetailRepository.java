package com.floreselmachetaso.jardineria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.domain.entities.OrderDetail;
import com.floreselmachetaso.jardineria.domain.entities.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
