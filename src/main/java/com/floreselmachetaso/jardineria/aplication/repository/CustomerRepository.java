package com.floreselmachetaso.jardineria.aplication.repository;

import com.floreselmachetaso.jardineria.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> getOneOptional(Integer id);
}
