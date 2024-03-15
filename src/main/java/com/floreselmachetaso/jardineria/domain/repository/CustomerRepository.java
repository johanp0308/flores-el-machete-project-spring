package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
