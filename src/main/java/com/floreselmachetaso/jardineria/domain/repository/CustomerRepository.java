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

    /*
     * Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
     */
    @Query("SELECT DISTINCT c.nombre_cliente FROM cliente AS c JOIN pedido AS p ON c.codigo_cliente = p.codigo_cliente WHERE p.fecha_entrega > p.fecha_esperada")
    List<Object[]> findAllCustomerDeliveNotTime();

    /*
     * Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
     */
    @Query("SELECT c.nombre_cliente, GROUP_CONCAT(DISTINCT gp.gama SEPARATOR ', ') AS gamas_compradas FROM cliente AS c JOIN pedido AS p ON c.codigo_cliente = p.codigo_cliente JOIN detalle_pedido AS dp ON p.codigo_pedido = dp.codigo_pedido JOIN producto AS pr ON dp.codigo_producto = pr.codigo_producto JOIN gama_producto AS gp ON pr.gama = gp.gama GROUP BY c.nombre_cliente")
    List<Object[]> findAllRangesPayACustomer();
    /*
     * Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
     */
    @Query("SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)")
    List<Object[]> findAllCustomerNoPay();

    /*
     * Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
     */
    @Query("SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)")
    List<Object[]> findAllCustomerNoOrder();

    /*
     * Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
     */
    @Query("SELECT * " + 
            "FROM cliente " + 
            "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago) " + 
            "UNION " + 
            "SELECT * " + 
            "FROM cliente " + 
            "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)")
     List<Object[]> findAllCustomerNoPayNoOrder();

    /*
     * Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
     */
    @Query("SELECT * " + //
                "FROM cliente " + //
                "WHERE codigo_cliente IN ( " + //
                "    SELECT DISTINCT codigo_cliente " + //
                "    FROM pedido " + //
                ") AND codigo_cliente NOT IN ( " + //
                "    SELECT DISTINCT codigo_cliente " + //
                "    FROM pago " + //
                ");")
    List<Object[]> findAllCustomerWOrderNotPay();
    
}
