package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.persistence.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
