package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    /*
     * ¿Cuál fue el pago medio en 2009?
     */
    @Query(value = "SELECT AVG(total) AS pago_medio_year  " + //
                "FROM pago  " + //
                "WHERE YEAR(fecha_pago) = 2009", nativeQuery = true)
    List<Object[]> averagePayYear();

    /*
     * Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
     */
    @Query(value = "SELECT  " + //
    "    c.nombre_cliente,  " + //
    "    c.nombre_contacto,  " + //
    "    c.apellido_contacto, " + //
    "    MIN(p.fecha_pago) AS primera_fecha_pago, " + //
    "    MAX(p.fecha_pago) AS ultima_fecha_pago " + //
    "FROM  " + //
    "    cliente c " + //
    "LEFT JOIN  " + //
    "    pago p ON c.codigo_cliente = p.codigo_cliente " + //
    "GROUP BY  " + //
    "    c.codigo_cliente,  " + //
    "    c.nombre_cliente,  " + //
    "    c.nombre_contacto,  " + //
    "    c.apellido_contacto", nativeQuery = true)
    List<Object[]> endDatePayForCustomer();

    /*
     * Calcula el número de productos diferentes que hay en cada uno de los pedidos.
     */
    @Query(value = "SELECT codigo_pedido, COUNT(DISTINCT codigo_producto) AS num_productos_diferentes " + //
                "FROM detalle_pedido " + //
                "GROUP BY codigo_pedido", nativeQuery = true)
    List<Object[]> amountCustomerDiffOrder();

    /*
     * Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
     */
    @Query(value = "SELECT codigo_pedido, SUM(cantidad) AS cantidad_total_productos " + //
                "FROM detalle_pedido " + //
                "GROUP BY codigo_pedido", nativeQuery = true)
    List<Object[]> sumAmountCustomerDiffOrder();

    /*
     * Devuelve un listado de los <Canitidad a mostrar> productos más vendidos y el número total de unidades que se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
     */
    @Query(value = "SELECT  " + //
                "    dp.codigo_producto, " + //
                "    p.nombre AS nombre_producto, " + //
                "    SUM(dp.cantidad) AS total_unidades_vendidas " + //
                "FROM  " + //
                "    detalle_pedido AS dp " + //
                "JOIN  " + //
                "    producto AS p ON dp.codigo_producto = p.codigo_producto " + //
                "GROUP BY  " + //
                "    dp.codigo_producto, p.nombre " + //
                "ORDER BY  " + //
                "    total_unidades_vendidas DESC " + //
                "LIMIT 20", nativeQuery = true)
    List<Object[]> topProductsMoreSales();


}
