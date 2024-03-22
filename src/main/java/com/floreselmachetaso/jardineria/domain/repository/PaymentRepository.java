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
     * Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla pagos.
     */
    @Query(value = "SELECT YEAR(fecha_pago) AS año, SUM(total) AS suma_total_pagos " + //
            "FROM pago " + //
            "GROUP BY YEAR(fecha_pago)", nativeQuery = true)
    List<Object[]> sumTotalPaysAllYear();

    /*
     * Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
     */

    @Query(value = "SELECT DISTINCT forma_pago FROM pago", nativeQuery = true)
    List<Object[]> findAllPaymentMethodS();

    /*
     * Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
     */
    @Query(value = "SELECT * FROM pago WHERE YEAR(fecha_pago) = 2008 AND forma_pago = 'Paypal' ORDER BY total DESC", nativeQuery = true)
    List<Object[]> findAllPayPalYearOrderDesc();

    /*
     * Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
     */
    @Query(value = "SELECT DISTINCT codigo_cliente FROM pago WHERE YEAR(fecha_pago) = 2008", nativeQuery = true)
    List<Object[]> findAllCustomerPayForYear();


}
