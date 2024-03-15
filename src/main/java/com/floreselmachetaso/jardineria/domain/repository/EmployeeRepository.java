package com.floreselmachetaso.jardineria.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    /*
     * Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
     */
    @Query("SELECT e.nombre, e.apellido1, e.apellido2, e.email FROM  empleado e WHERE e.codigo_jefe = ?")
    List<Object[]> findAllEmplyeWCodeBoss(Long codeBoss);

    /*
     * Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa
     */
    @Query("SELECT e.puesto, e.nombre, e.apellido1, e.apellido2, e.email FROM empleado e WHERE e.codigo_jefe IS NULL")
    List<Object[]> findBossEvryOne();

    /*
     * Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
     */
    @Query("SELECT e.nombre, e.apellido1, e.apellido2, e.puesto FROM empleado e WHERE e.puesto NOT LIKE 'Representante Ventas'")
    List<Object[]> findAllNotSalesRepresentative();


}