package com.floreselmachetaso.jardineria.aplication.repository;

import com.floreselmachetaso.jardineria.domain.entities.OrderDetail;
import com.floreselmachetaso.jardineria.domain.entities.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
