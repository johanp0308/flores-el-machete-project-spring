package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /*
     * Devuelve un listado con los disYtintos estados por los que puede pasar un pedido.
     */
    @Query(value = "SELECT DISTINCT estado FROM pedido", nativeQuery = true)
    List<Object[]> findAllStatusOrder();


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
     * ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
     */
    @Query(value = "SELECT estado, COUNT(*) AS total_pedidos " + //
                "FROM pedido " + //
                "GROUP BY estado " + //
                "ORDER BY total_pedidos DESC", nativeQuery = true)
    List<Object[]> amountOrderState();


}
