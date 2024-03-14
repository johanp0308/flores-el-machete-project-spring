package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.persistence.entities.OrderDetail;
import com.floreselmachetaso.jardineria.persistence.entities.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
