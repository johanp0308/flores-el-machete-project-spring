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
    @Query("SELECT  " + //
                "    pr.nombre AS nombre_producto, " + //
                "    SUM(dp.cantidad) AS unidades_vendidas, " + //
                "    SUM(dp.cantidad * pr.precio_venta) AS total_facturado_sin_iva, " + //
                "    SUM(dp.cantidad * pr.precio_venta) * 1.21 AS total_facturado_con_iva " + //
                "FROM  " + //
                "    detalle_pedido AS dp " + //
                "JOIN  " + //
                "    producto AS pr ON dp.codigo_producto = pr.codigo_producto " + //
                "JOIN  " + //
                "    pedido AS pe ON dp.codigo_pedido = pe.codigo_pedido " + //
                "JOIN  " + //
                "    gama_producto AS gp ON pr.gama = gp.gama " + //
                "JOIN  " + //
                "    cliente AS c ON pe.codigo_cliente = c.codigo_cliente " + //
                "GROUP BY  " + //
                "    dp.codigo_producto, pr.nombre " + //
                "HAVING  " + //
                "    total_facturado_sin_iva > ?")
    List<Object[]> findAllSalesByPrice(int price);
    
    /*
     * Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla pagos.
     */
    @Query("SELECT YEAR(fecha_pago) AS año, SUM(total) AS suma_total_pagos " + //
                "FROM pago " + //
                "GROUP BY YEAR(fecha_pago)")
    List<Object[]> sumTotalPaysAllYear();
}
