package com.floreselmachetaso.jardineria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
