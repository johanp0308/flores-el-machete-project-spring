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

    /*
     * Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.
     */

     @Query("SELECT c.* FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado WHERE c.ciudad = 1? AND e.codigo_empleado IN (2?, 3?)")
     List<Object[]> findAllCustomerbyCityWRepresentIdOrId(String city,int repre1, int repre2);
}
