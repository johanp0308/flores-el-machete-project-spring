package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /*
     * Devuelve un listado con los distintos estados por los que puede pasar un pedido.
     */
    @Query(value = "SELECT DISTINCT estado FROM pedido", nativeQuery = true)
    List<Object[]> findAllStatusOrder();

    /*
     * Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
     */
    @Query(value = "SELECT DISTINCT codigo_cliente FROM pago WHERE YEAR(fecha_pago) = 2008", nativeQuery = true)
    List<Object[]> findAllCustomerPayForYear();

    /*
     * Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
     */
    @Query(value = "SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE fecha_entrega > fecha_esperada", nativeQuery = true)
    List<Object[]> findAllOrderDelivNotTime();

    /*
     * Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
     */
    @Query(value = "SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE DATEDIFF(fecha_esperada, fecha_entrega) >= 2", nativeQuery = true)
    List<Object[]> findAllOrderDelivNotTimeDiffTwoDay();
    
    /*
     * Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
     */
    @Query(value = "SELECT codigo_pedido, fecha_pedido, estado FROM pedido WHERE estado = 'rechazado' AND YEAR(fecha_pedido) = 2009", nativeQuery = true)
    List<Object[]> findAllOrderRejected();
    
    /*
     * Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
     */
    @Query(value = "SELECT codigo_pedido, fecha_entrega FROM pedido WHERE MONTH(fecha_entrega) = 1", nativeQuery = true)
    List<Object[]> findAllOrderNotDelivInMonthJanaury();

    /*
     * Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
     */
    @Query(value = "SELECT * FROM pago WHERE YEAR(fecha_pago) = 2008 AND forma_pago = 'Paypal' ORDER BY total DESC", nativeQuery = true)
    List<Object[]> findAllPayPalYearOrderDesc();

    /*
     * Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
     */
    
    @Query(value = "SELECT DISTINCT forma_pago FROM pago", nativeQuery = true)
    List<Object[]> findAllPaymentMethodS();

    /*
     * ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
     */
    @Query(value = "SELECT estado, COUNT(*) AS total_pedidos " + //
                "FROM pedido " + //
                "GROUP BY estado " + //
                "ORDER BY total_pedidos DESC", nativeQuery = true)
    List<Object[]> amountOrderState();

    /*
     * La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.
     */
    @Query(value = "SELECT  " + //
                "    SUM(dp.cantidad * pr.precio_venta) AS base_imponible, " + //
                "    SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva, " + //
                "    SUM(dp.cantidad * pr.precio_venta) + (SUM(dp.cantidad * pr.precio_venta) * 0.21) AS total_facturado " + //
                "FROM  " + //
                "    detalle_pedido AS dp " + //
                "JOIN  " + //
                "    producto AS pr ON dp.codigo_producto = pr.codigo_producto", nativeQuery = true)
    List<Object[]> billingCompany();

    /*
     * La misma información que en la pregunta anterior, pero agrupada por código de producto.
     */
    @Query(value = "SELECT  " + //
                "    dp.codigo_producto, " + //
                "    SUM(dp.cantidad * pr.precio_venta) AS base_imponible, " + //
                "    SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva, " + //
                "    SUM(dp.cantidad * pr.precio_venta) + (SUM(dp.cantidad * pr.precio_venta) * 0.21) AS total_facturado " + //
                "FROM  " + //
                "    detalle_pedido AS dp " + //
                "JOIN  " + //
                "    producto AS pr ON dp.codigo_producto = pr.codigo_producto " + //
                "GROUP BY  " + //
                "    dp.codigo_producto", nativeQuery = true)
    List<Object[]> billingCompanyByProduct();
}
