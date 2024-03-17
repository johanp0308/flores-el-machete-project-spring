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

    /*
    * Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
    */
    @Query("Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.")
    List<Object[]> findAllCustomerWSalesRepres();

    /*
     * Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
     */
    @Query("SELECT cli.nombre_cliente, emp.nombre AS nombre_representante, emp.apellido1 AS apellido_representante FROM cliente AS cli JOIN pago AS p ON cli.codigo_cliente = p.codigo_cliente JOIN empleado AS emp ON cli.codigo_empleado_rep_ventas = emp.codigo_empleado")
    List<Object[]> findAllCustomerWSalesRepresPay();

    /*
     * Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
     */
    @Query("SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente AS c JOIN pago AS p ON c.codigo_cliente = p.codigo_cliente JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina")

    List<Object[]> findAllCustomerWSalesRepresPayWCity();

    /*
     * Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
     */
    @Query("SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente AS c JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina WHERE c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)")
    List<Object[]> findAllCustomerWSalesRepresNoPayWCity();

    /*
     * Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
     */
    @Query("SELECT DISTINCT o.linea_direccion1, o.linea_direccion2, o.ciudad, o.pais FROM oficina AS o JOIN empleado AS e ON o.codigo_oficina = e.codigo_oficina JOIN cliente AS c ON e.codigo_empleado = c.codigo_empleado_rep_ventas WHERE c.ciudad = ?")
    List<Object[]> findAllCustomerAddressWCity(String city);

    /*
     * Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
     */
    @Query("SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente AS c JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina")
    List<Object[]> findAllCustomerAndSalesRepresWCity();

}
