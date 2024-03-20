package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    /*
     * Devuelve un listado de los productos que nunca han aparecido en un pedido.
     */
    @Query(value = "SELECT * " + //
                "FROM producto " + //
                "WHERE codigo_producto NOT IN (SELECT DISTINCT codigo_producto FROM detalle_pedido)", nativeQuery = true)
    List<Object[]> findAllProductsNotOrder();

    /*
     * Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.
     */
    @Query(value = "SELECT p.nombre, p.descripcion, gp.imagen " + //
                "FROM producto AS p " + //
                "LEFT JOIN detalle_pedido AS dp ON p.codigo_producto = dp.codigo_producto " + //
                "LEFT JOIN gama_producto AS gp ON p.gama = gp.gama " + //
                "WHERE dp.codigo_producto IS NULL", nativeQuery = true)
    List<Object[]> findAllProductsNotOrderFields();

    /*
     * Calcula el precio de venta del producto más caro y más barato en una misma consulta.
     */
    @Query(value = "SELECT 'Producto más caro' AS tipo, MAX(precio_venta) AS precio  " + //
                "FROM producto  " + //
                "UNION  " + //
                "SELECT 'Producto más barato' AS tipo, MIN(precio_venta) AS precio  " + //
                "FROM producto", nativeQuery = true)
    List<Object[]> productExpensiveAndCheap();

    
}
