package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String>  {

    /*
     * The Query is: Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
     * 
     */
    @Query(value = "SELECT codigo_oficina as Codigo, ciudad as Ciudad FROM oficina", nativeQuery = true)
    List<Object[]> findAllOfficeWCity();
    
    /*
     * Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
     */
    @Query(value = "SELECT ciudad as Ciudad, telefono as Telefono FROM oficina WHERE pais LIKE 'España'", nativeQuery = true)
    List<Object[]> findAllWOfficeWCountry();
    
    /*
     * Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
     */
    @Query(value = "SELECT * FROM oficina WHERE codigo_oficina NOT IN ( " + //
    "    SELECT DISTINCT e.codigo_oficina " + //
    "    FROM empleado e " + //
    "    JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas " + //
    "    JOIN pedido p ON c.codigo_cliente = p.codigo_cliente " + //
    "    JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido " + //
    "    JOIN producto pr ON dp.codigo_producto = pr.codigo_producto " + //
    "    WHERE pr.gama = 'Frutales'" + //
    ")", nativeQuery = true)
    List<Object[]> findAllOfficeWEmployeWCustomerPayAGamaFrut();

    

}
