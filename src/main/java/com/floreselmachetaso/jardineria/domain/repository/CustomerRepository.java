package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  /*
   * List of Spanish customers
   */
  @Query(value = "SELECT nombre_cliente FROM cliente WHERE pais = 'Spain'", nativeQuery = true)
  List<Object[]> findAllCustomerSpain();

  /*
   * Customers from Madrid whose sales representative has employee code 11 or 30
   */
  @Query(value = "SELECT c.* FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado WHERE c.ciudad = 'Madrid' AND e.codigo_empleado IN (11, 30)", nativeQuery = true)
  List<Object[]> findAllCustomerbyCityWRepresentIdOrId();

  /*
   * Name of each customer and name and surname of their sales representative
   */
  @Query(value = "SELECT cli.nombre_cliente, emp.nombre, emp.apellido1 FROM cliente cli JOIN empleado emp ON cli.codigo_empleado_rep_ventas = emp.codigo_empleado", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepres();

  /*
   * Name of customers who have made payments along with the name of their sales representatives
   */
  @Query(value = "SELECT cli.nombre_cliente, emp.nombre AS nombre_representante, emp.apellido1 AS apellido_representante FROM cliente cli JOIN pago p ON cli.codigo_cliente = p.codigo_cliente JOIN empleado emp ON cli.codigo_empleado_rep_ventas = emp.codigo_empleado", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresPay();

  /*
   * Name of customers who have made payments and the name of their representatives along with the city of the representative's office
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN pago p ON c.codigo_cliente = p.codigo_cliente JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresPayWCity();

  /*
   * Name of customers who have not made payments and the name of their representatives along with the city of the representative's office
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina WHERE c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerWSalesRepresNoPayWCity();

  /*
   * Address of offices with customers in Fuenlabrada
   */
  @Query(value = "SELECT DISTINCT o.linea_direccion1, o.linea_direccion2, o.ciudad, o.pais FROM oficina o JOIN empleado e ON o.codigo_oficina = e.codigo_oficina JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas WHERE c.ciudad = 'Fuenlabrada'", nativeQuery = true)
  List<Object[]> findAllCustomerAddressWCity();

  /*
   * Name of customers and name of their representatives along with the city of the representative's office
   */
  @Query(value = "SELECT c.nombre_cliente, e.nombre AS nombre_representante, e.apellido1 AS apellido_representante, o.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina o ON e.codigo_oficina = o.codigo_oficina", nativeQuery = true)
  List<Object[]> findAllCustomerAndSalesRepresWCity();

  /*
   * Name of customers who have not been delivered orders on time
   */
  @Query(value = "SELECT DISTINCT c.nombre_cliente FROM cliente c JOIN pedido p ON c.codigo_cliente = p.codigo_cliente WHERE p.fecha_entrega > p.fecha_esperada", nativeQuery = true)
  List<Object[]> findAllCustomerDeliveNotTime();

  /*
   * Different product ranges purchased by each customer
   */
  @Query(value = "SELECT c.nombre_cliente, GROUP_CONCAT(DISTINCT gp.gama SEPARATOR ', ') AS gamas_compradas FROM cliente c JOIN pedido p ON c.codigo_cliente = p.codigo_cliente JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido JOIN producto pr ON dp.codigo_producto = pr.codigo_producto JOIN gama_producto gp ON pr.gama = gp.gama GROUP BY c.nombre_cliente", nativeQuery = true)
  List<Object[]> findAllRangesPayACustomer();

  /*
   * Different product ranges purchased by each customer
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerNoPay();

  /*
   * Customers who have not placed any orders
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)", nativeQuery = true)
  List<Object[]> findAllCustomerNoOrder();

  /*
   * Customers who have not made any payments and have not placed any orders
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago) UNION SELECT * FROM cliente WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)", nativeQuery = true)
  List<Object[]> findAllCustomerNoPayNoOrder();

  /*
   * Customers who have placed orders but have not made any payments
   */
  @Query(value = "SELECT * FROM cliente WHERE codigo_cliente IN (SELECT DISTINCT codigo_cliente FROM pedido) AND codigo_cliente NOT IN (SELECT DISTINCT codigo_cliente FROM pago)", nativeQuery = true)
  List<Object[]> findAllCustomerWOrderNotPay();

  /*
   * How many customers are there in each country?
   */
  @Query(value = "SELECT pais, COUNT(*) AS total_clientes FROM cliente GROUP BY pais", nativeQuery = true)
  List<Object[]> amountCustomerCountry();

  /*
   * Calculate the number of customers the company has.
   */
  @Query(value = "SELECT COUNT(*) AS total_customers FROM customer", nativeQuery = true)
  List<Object[]> numberCustomerOfCompany();

  /*
   * How many customers exist with an address in the city of Madrid?
   */
  @Query(value = "SELECT COUNT(*) AS total_customers_madrid FROM customer WHERE city = 'Madrid'", nativeQuery = true)
  List<Object[]> amountCustomerByCity();

  /*
   * Calculate how many customers each of the cities starting with M has.
   */
  @Query(value = "SELECT city, COUNT(*) AS total_customers FROM customer WHERE city LIKE 'M%' GROUP BY city", nativeQuery = true)
  List<Object[]> searchCustomerByCityStart();

  /*
   * Calculate the number of customers that do not have a sales representative assigned.
   */
  @Query(value = "SELECT COUNT(*) AS customers_without_sales_rep FROM customer WHERE sales_representative_code IS NULL", nativeQuery = true)
  List<Object[]> amountCustomerNotSalesRepres();


}
