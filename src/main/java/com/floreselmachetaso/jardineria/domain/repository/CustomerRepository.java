package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*
     * Devuelve un listado con el nombre de los todos los clientes españoles.
     */
    @Query("SELECT c.nombre_cliente FROM cliente c WHERE c.pais LIKE 'Spain'")
    List<Object[]> findAllCustomerSpain();
}
