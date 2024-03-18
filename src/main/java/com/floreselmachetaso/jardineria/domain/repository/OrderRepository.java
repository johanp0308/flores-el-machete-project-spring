package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /*
     * Devuelve un listado con los distintos estados por los que puede pasar un pedido.
     */
    @Query("SELECT DISTINCT p.estado FROM pedido p")
    List<Object[]> findAllStatusOrder();

    /*
     * Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
     */
    @Query("SELECT DISTINCT p.codigo_cliente FROM pago p WHERE YEAR(fecha_pago) = ?")
    List<Object[]> findAllCustomerPayForYear(int year);

    /*
     * Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
     */
    @Query("SELECT p.codigo_pedido, p.codigo_cliente, p.fecha_esperada, p.fecha_entrega FROM pedido p WHERE fecha_entrega > fecha_esperada")
    List<Object[]> findAllOrderDelivNotTime();

    /*
     * Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
     */
    @Query("SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE DATEDIFF(fecha_esperada, fecha_entrega) >= ?")
    List<Object[]> findAllOrderDelivNotTimeDiffDay(int id);
    
    /*
     * Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
     */
    @Query("SELECT codigo_pedido, fecha_pedido, estado FROM pedido WHERE estado = 'rechazado' AND YEAR(fecha_pedido) = ?")
    List<Object[]> findAllOrderRejected(int year);
    
    /*
     * Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
     */
    @Query("SELECT codigo_pedido, fecha_entrega FROM pedido WHERE MONTH(fecha_entrega) = 1")
    List<Object[]> findAllOrderNotDelivInMonthJanaury();

    /*
     * Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
     */
    @Query("SELECT * FROM pago WHERE YEAR(fecha_pago) = ? AND forma_pago = 'Paypal' ORDER BY total DESC")
    List<Object[]> findAllPayPalYearOrderDesc(int year);

    /*
     * Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
     */
    
    @Query("SELECT DISTINCT forma_pago FROM pago")
    List<Object[]> findAllPaymentMethodS();

    /*
     * ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
     */
    @Query("SELECT estado, COUNT(*) AS total_pedidos " + //
                "FROM pedido " + //
                "GROUP BY estado " + //
                "ORDER BY total_pedidos DESC")
    List<Object[]> amountOrderState();
}
