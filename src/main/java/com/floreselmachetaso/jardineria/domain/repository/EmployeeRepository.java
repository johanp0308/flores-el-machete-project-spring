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

    /*
     * Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
     */
    @Query("SELECT e1.nombre AS nombre_empleado, e2.nombre AS nombre_jefe FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado")
    List<Object[]> findAllEmployeeAndBoss();

    /*
     * Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
     */
    @Query("SELECT e1.nombre AS nombre_empleado, e2.nombre AS nombre_jefe, e3.nombre AS nombre_jefe_jefe FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado LEFT JOIN empleado AS e3 ON e2.codigo_jefe = e3.codigo_empleado")
    List<Object[]> findAllEmployeeAndBossAndBoss();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
     */
    @Query("SELECT * FROM empleado WHERE codigo_oficina IS NULL")
    List<Object[]> findAllEmployeeNotOffice();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
     */
    @Query("SELECT * " + 
                "FROM empleado " + 
                "WHERE codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente)")
    List<Object[]> findAllEmployeeNotCustomer();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
     */
    @Query("SELECT e.*, o.* " + //
                "FROM empleado AS e " + //
                "LEFT JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina " + //
                "WHERE e.codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente);")
    List<Object[]> findAllEmployeeNotCustomerWDataOffice();

    /*
     * Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
     */
    @Query("SELECT * " + //
                "FROM empleado " + //
                "WHERE codigo_oficina IS NULL " + //
                "UNION " + //
                "SELECT e.* " + //
                "FROM empleado e " + //
                "LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas " + //
                "WHERE c.codigo_cliente IS NULL; " + //
                "")
    List<Object[]> findAllEmployeeNotOfficeANotCustomer();

    /*
     * Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
     */
    @Query("SELECT e1.*, e2.nombre AS nombre_jefe, e2.apellido1 AS apellido_jefe " + //
                "FROM empleado AS e1 " + //
                "LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado " + //
                "WHERE e1.codigo_empleado NOT IN ( " + //
                "    SELECT DISTINCT codigo_empleado_rep_ventas " + //
                "    FROM cliente " + //
                ")")
    List<Object[]> findAllDataEmployeNotCustomerAndBoss();

    /*
     * ¿Cuántos empleados hay en la compañía?
     */
    @Query("SELECT COUNT(*) AS total_empleados " + //
                "FROM empleado")
    List<Object[]> amountEmployee();

    
}