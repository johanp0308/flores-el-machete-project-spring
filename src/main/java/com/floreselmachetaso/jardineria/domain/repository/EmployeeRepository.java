package com.floreselmachetaso.jardineria.domain.repository;


import java.util.List;

import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    /*
     * Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
     */
    @Query(value = "SELECT  codigo_empleado, nombre, apellido1, apellido2, email, codigo_jefe FROM empleado WHERE codigo_jefe = 7", nativeQuery = true)
    List<Object[]> findAllEmplyeWCodeBoss();

    /*
     * Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa
     */
    @Query(value = "SELECT puesto, nombre, apellido1, apellido2, email FROM empleado WHERE codigo_jefe IS NULL", nativeQuery = true)
    List<Object[]> findBossEvryOne();

    /*
     * Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
     */
    @Query(value = "SELECT nombre, apellido1, apellido2, puesto FROM empleado WHERE puesto NOT LIKE 'Representante Ventas'", nativeQuery = true)
    List<Object[]> findAllNotSalesRepresentative();

    /*
     * Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
     */
    @Query(value = "SELECT e1.nombre AS nombre_empleado, e2.nombre AS nombre_jefe FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado", nativeQuery = true)
    List<Object[]> findAllEmployeeAndBoss();

    /*
     * Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
     */
    @Query(value = "SELECT e1.nombre AS nombre_empleado, e2.nombre AS nombre_jefe, e3.nombre AS nombre_jefe_jefe FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado LEFT JOIN empleado AS e3 ON e2.codigo_jefe = e3.codigo_empleado", nativeQuery = true)
    List<Object[]> findAllEmployeeAndBossAndBoss();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
     */
    @Query(value = "SELECT * FROM empleado WHERE codigo_oficina IS NULL", nativeQuery = true)
    List<Object[]> findAllEmployeeNotOffice();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
     */
    @Query(value = "SELECT * FROM empleado WHERE codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente)", nativeQuery = true)
    List<Object[]> findAllEmployeeNotCustomer();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
     */
    @Query(value = "SELECT e.*, o.* FROM empleado AS e LEFT JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina WHERE e.codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente)", nativeQuery = true)
    List<Object[]> findAllEmployeeNotCustomerWDataOffice();

    /*
     * Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
     */
    @Query(value = "SELECT * FROM empleado WHERE codigo_oficina IS NULL UNION SELECT e.* FROM empleado e LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas WHERE c.codigo_cliente IS NULL", nativeQuery = true)
    List<Object[]> findAllEmployeeNotOfficeANotCustomer();

    /*
     * Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
     */
    @Query(value = "SELECT e1.*, e2.nombre AS nombre_jefe, e2.apellido1 AS apellido_jefe FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado WHERE e1.codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente)", nativeQuery = true)
    List<Object[]> findAllDataEmployeNotCustomerAndBoss();

    /*
     * ¿Cuántos empleados hay en la compañía?
     */
    @Query(value = "SELECT COUNT(*) AS total_empleados FROM empleado", nativeQuery = true)
    List<Object[]> amountEmployee();

    /* 
     * Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
    */
    @Query(value = "SELECT e.nombre, e.apellido1, COUNT(c.codigo_cliente) AS total_clientes FROM empleado AS e LEFT JOIN cliente AS c ON e.codigo_empleado = c.codigo_empleado_rep_ventas GROUP BY e.codigo_empleado, e.nombre, e.apellido1", nativeQuery = true)
    List<Object[]> findAllSalesRepresandNumberCustomer();
    
}