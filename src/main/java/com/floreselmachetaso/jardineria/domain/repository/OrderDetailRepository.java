package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.OrderDetail;
import com.floreselmachetaso.jardineria.persistence.entities.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

    /*
     * Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).
     */
    @Query(value = "SELECT " + //
                "    pr.nombre AS nombre_producto, " + //
                "    SUM(dp.cantidad) AS unidades_vendidas, " + //
                "    SUM(dp.cantidad * pr.precio_venta) AS total_facturado_sin_iva, " + //
                "    SUM(dp.cantidad * pr.precio_venta) * 1.21 AS total_facturado_con_iva " + //
                "FROM " + //
                "    detalle_pedido AS dp " + //
                "JOIN " + //
                "    producto AS pr ON dp.codigo_producto = pr.codigo_producto " + //
                "JOIN " + //
                "    pedido AS pe ON dp.codigo_pedido = pe.codigo_pedido " + //
                "JOIN " + //
                "    gama_producto AS gp ON pr.gama = gp.gama " + //
                "JOIN " + //
                "    cliente AS c ON pe.codigo_cliente = c.codigo_cliente " + //
                "GROUP BY " + //
                "    dp.codigo_producto, pr.nombre " + //
                "HAVING " + //
                "    total_facturado_sin_iva > 3000", nativeQuery = true)
    List<Object[]> findAllSalesByPrice();

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

    /*
     * Calcula el número de productos diferentes que hay en cada uno de los pedidos.
     */
    @Query(value = "SELECT codigo_pedido, COUNT(DISTINCT codigo_producto) AS num_productos_diferentes " + //
            "FROM detalle_pedido " + //
            "GROUP BY codigo_pedido", nativeQuery = true)
    List<Object[]> amountCustomerDiffOrder();

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
