package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.OrderDetail;
import com.floreselmachetaso.jardineria.persistence.entities.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

    /*
     * Lists the total sales of products that have billed more than 3000 euros. It will show the name, units sold, total billed, and total billed with taxes (21% VAT).
     */
    @Query(value = "SELECT " + //
            "    pr.name AS product_name, " + //
            "    SUM(od.quantity) AS units_sold, " + //
            "    SUM(od.quantity * pr.sale_price) AS total_billed_without_vat, " + //
            "    SUM(od.quantity * pr.sale_price) * 1.21 AS total_billed_with_vat " + //
            "FROM " + //
            "    order_detail AS od " + //
            "JOIN " + //
            "    product AS pr ON od.product_code = pr.product_code " + //
            "JOIN " + //
            "    order AS o ON od.order_code = o.order_code " + //
            "JOIN " + //
            "    product_line AS pl ON pr.product_line = pl.product_line " + //
            "JOIN " + //
            "    customer AS c ON o.customer_code = c.customer_code " + //
            "GROUP BY " + //
            "    od.product_code, pr.name " + //
            "HAVING " + //
            "    total_billed_without_vat > 3000", nativeQuery = true)
    List<Object[]> findAllSalesByPrice();

    /*
     * Returns a list of the top 20 best-selling products and the total number of units sold for each one. The list should be ordered by the total number of units sold.
     */
    @Query(value = "SELECT  " + //
            "    od.product_code, " + //
            "    p.name AS product_name, " + //
            "    SUM(od.quantity) AS total_units_sold " + //
            "FROM  " + //
            "    order_detail AS od " + //
            "JOIN  " + //
            "    product AS p ON od.product_code = p.product_code " + //
            "GROUP BY  " + //
            "    od.product_code, p.name " + //
            "ORDER BY  " + //
            "    total_units_sold DESC " + //
            "LIMIT 20", nativeQuery = true)
    List<Object[]> topProductsMoreSales();

    /*
     * Calculates the number of different products in each order.
     */
    @Query(value = "SELECT order_code, COUNT(DISTINCT product_code) AS num_different_products " + //
            "FROM order_detail " + //
            "GROUP BY order_code", nativeQuery = true)
    List<Object[]> amountCustomerDiffOrder();

    /*
     * The company's billing throughout its history, indicating the taxable base, the VAT, and the total billed. The taxable base is calculated by adding the product cost multiplied by the number of units sold from the order_detail table. The VAT is 21% of the taxable base, and the total is the sum of the two previous fields.
     */
    @Query(value = "SELECT  " + //
            "    SUM(od.quantity * pr.sale_price) AS taxable_base, " + //
            "    SUM(od.quantity * pr.sale_price) * 0.21 AS vat, " + //
            "    SUM(od.quantity * pr.sale_price) + (SUM(od.quantity * pr.sale_price) * 0.21) AS total_billed " + //
            "FROM  " + //
            "    order_detail AS od " + //
            "JOIN  " + //
            "    product AS pr ON od.product_code = pr.product_code", nativeQuery = true)
    List<Object[]> billingCompany();

    /*
     * The same information as the previous question, but grouped by product code.
     */
    @Query(value = "SELECT  " + //
            "    od.product_code, " + //
            "    SUM(od.quantity * pr.sale_price) AS taxable_base, " + //
            "    SUM(od.quantity * pr.sale_price) * 0.21 AS vat, " + //
            "    SUM(od.quantity * pr.sale_price) + (SUM(od.quantity * pr.sale_price) * 0.21) AS total_billed " + //
            "FROM  " + //
            "    order_detail AS od " + //
            "JOIN  " + //
            "    product AS pr ON od.product_code = pr.product_code " + //
            "GROUP BY  " + //
            "    od.product_code", nativeQuery = true)
    List<Object[]> billingCompanyByProduct();

}
