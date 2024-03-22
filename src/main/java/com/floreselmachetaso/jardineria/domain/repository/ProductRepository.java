package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    /*
     * Returns a list of products that have never appeared in an order.
     */
    @Query(value = "SELECT * " + //
            "FROM product " + //
            "WHERE product_code NOT IN (SELECT DISTINCT product_code FROM order_detail)", nativeQuery = true)
    List<Product> findAllProductsNotOrder();

    /*
     * Returns a list of products that have never appeared in an order. The result should show the name, description, and image of the product.
     */
    @Query(value = "SELECT p.name, p.description, pl.image " + //
            "FROM product AS p " + //
            "LEFT JOIN order_detail AS od ON p.product_code = od.product_code " + //
            "LEFT JOIN product_line AS pl ON p.product_line = pl.product_line " + //
            "WHERE od.product_code IS NULL", nativeQuery = true)
    List<Object[]> findAllProductsNotOrderFields();

    /*
     * Calculates the selling price of the most expensive and cheapest product in a single query.
     */
    @Query(value = "SELECT 'Most Expensive Product' AS type, MAX(selling_price) AS price  " + //
            "FROM product  " + //
            "UNION  " + //
            "SELECT 'Cheapest Product' AS type, MIN(selling_price) AS price  " + //
            "FROM product", nativeQuery = true)
    List<Object[]> productExpensiveAndCheap();

    /*
     * Calculates the sum of the total quantity of all products that appear in each of the orders.
     */
    @Query(value = "SELECT order_code, SUM(quantity) AS total_quantity_products " + //
            "FROM order_detail " + //
            "GROUP BY order_code", nativeQuery = true)
    List<Object[]> sumAmountCustomerDiffOrder();


}
