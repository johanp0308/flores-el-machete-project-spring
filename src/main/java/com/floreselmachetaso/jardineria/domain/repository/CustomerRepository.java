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
  @Query(value = "SELECT nombre_cliente FROM cliente WHERE pais = 'Spain'", nativeQuery = true)
  List<Object[]> findAllCustomerSpain();
  /*
   * Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y
   * cuyo representante de ventas tenga el código de empleado 11 o 30.
   */

  @Query(value = "SELECT * FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado WHERE c.ciudad = 'Madrid' AND e.codigo_empleado IN (11, 30)", nativeQuery = true)
  List<Object[]> findAllCustomerbyCityWRepresentIdOrId();

  /*
   * Obtén un listado con el nombre de cada cliente y el nombre y apellido de su
   * representante de ventas.
   */
  @Query(value = "SELECT cli.nombre_cliente, emp.nombre, emp.apellido1 FROM cliente cli JOIN empleado emp ON cli.codigo_empleado_rep_ventas = emp.codigo_empleado", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepres();

  /*
   * Muestra el nombre de los clientes que hayan realizado pagos junto con el
   * nombre de sus representantes de ventas.
   */
  @Query(value = "SELECT cli.nombre_cliente, emp.nombre AS nombre_representante, emp.apellido1 AS apellido_representante FROM cliente cli JOIN pago p ON cli.codigo_cliente = p.codigo_cliente JOIN empleado emp ON cli.codigo_empleado_rep_ventas = emp.codigo_empleado", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresPay();

  /*
   * Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus
   * representantes junto con la ciudad de la oficina a la que pertenece el
   * representante.
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN pago p ON c.codigo_cliente = p.codigo_cliente JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresPayWCity();

  /*
   * Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de
   * sus representantes junto con la ciudad de la oficina a la que pertenece el
   * representante.
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina WHERE c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresNoPayWCity();

  /*
   * Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
   */
  @Query(value = "SELECT DISTINCT o.linea_direccion1, o.linea_direccion2, o.ciudad, o.pais FROM oficina o JOIN empleado e ON o.codigo_oficina = e.codigo_oficina JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas WHERE c.ciudad = ?", nativeQuery = true)
  List<Object[]> findAllCustomerAddressWCity(String city);

  /*
   * Devuelve el nombre de los clientes y el nombre de sus representantes junto
   * con la ciudad de la oficina a la que pertenece el representante.
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina", nativeQuery = true)
  List<Object[]> findAllCustomerAndSalesRepresWCity();

  /*
   * Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo
   * un pedido.
   */
  @Query(value = "SELECT DISTINCT c.nombre_cliente FROM cliente c JOIN pedido p ON c.codigo_cliente = p.codigo_cliente WHERE p.fecha_entrega > p.fecha_esperada", nativeQuery = true)
  List<Object[]> findAllCustomerDeliveNotTime();

  /*
   * Devuelve un listado de las diferentes gamas de producto que ha comprado cada
   * cliente.
   */
  @Query(value = "SELECT c.nombre_cliente, GROUP_CONCAT(DISTINCT gp.gama SEPARATOR ', ') AS gamas_compradas FROM cliente c JOIN pedido p ON c.codigo_cliente = p.codigo_cliente JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido JOIN producto pr ON dp.codigo_producto = pr.codigo_producto JOIN gama_producto gp ON pr.gama = gp.gama GROUP BY c.nombre_cliente", nativeQuery = true)
  List<Object[]> findAllRangesPayACustomer();

  /*
   * Devuelve un listado que muestre solamente los clientes que no han realizado
   * ningún pago.
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerNoPay();

  /*
   * Devuelve un listado que muestre solamente los clientes que no han realizado
   * ningún pedido.
   */
    @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)", nativeQuery = true)
  List<Object[]> findAllCustomerNoOrder();

  /*
   * Devuelve un listado que muestre los clientes que no han realizado ningún pago
   * y los que no han realizado ningún pedido.
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago) UNION SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)", nativeQuery = true)
  List<Object[]> findAllCustomerNoPayNoOrder();

  /*
   * Devuelve un listado con los clientes que han realizado algún pedido pero no
   * han realizado ningún pago.
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente IN (SELECT DISTINCT codigo_cliente FROM pedido) AND codigo_cliente NOT IN (SELECT DISTINCT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerWOrderNotPay();

  /*
   * ¿Cuántos clientes tiene cada país?
   */
  @Query(value = "SELECT pais, COUNT(*) AS total_clientes FROM cliente GROUP BY pais", nativeQuery = true)
  List<Object[]> amountCustomerCountry();

  /*
   * Calcula el número de clientes que tiene la empresa.
   */
  @Query(value = "SELECT COUNT(*) AS total_clientes FROM cliente", nativeQuery = true)
  List<Object[]> numberCustomerOfCompany();

  /*
   * ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
   */
  @Query(value = "SELECT COUNT(*) AS total_clientes_madrid FROM cliente WHERE ciudad = 'Madrid'", nativeQuery = true)
  List<Object[]> amountCustomerByCity();

  /*
   * ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
   */
  @Query(value = "SELECT ciudad, COUNT(*) AS total_clientes FROM cliente WHERE ciudad LIKE 'M%' GROUP BY ciudad", nativeQuery = true)
  List<Object[]> searchCustomerByCityStart();

  /*
   * Calcula el número de clientes que no tiene asignado representante de ventas.
   */
  @Query(value = "SELECT COUNT(*) AS clientes_sin_representante FROM cliente WHERE codigo_empleado_rep_ventas IS NULL", nativeQuery = true)
  List<Object[]> amountCustomerNotSalesRepres();

}
