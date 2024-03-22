package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /*
     * List of order statuses
     */
    @Query(value = "SELECT DISTINCT status FROM order", nativeQuery = true)
    List<Object[]> findAllStatusOrder();


    /*
     * Orders not delivered on time with order code, customer code, expected date, and delivery date
     */
    @Query(value = "SELECT order_code, customer_code, expected_date, delivery_date FROM order WHERE delivery_date > expected_date", nativeQuery = true)
    List<Object[]> findAllOrderDelivNotTime();

    /*
     * Orders delivered at least two days before the expected date with order code, customer code, expected date, and delivery date*/
    @Query(value = "SELECT order_code, customer_code, expected_date, delivery_date FROM order WHERE DATEDIFF(expected_date, delivery_date) >= 2", nativeQuery = true)
    List<Object[]> findAllOrderDelivNotTimeDiffTwoDay();

    /*
     * Orders rejected in 2009
     */
    @Query(value = "SELECT order_code, order_date, status FROM order WHERE status = 'rejected' AND YEAR(order_date) = 2009", nativeQuery = true)
    List<Object[]> findAllOrderRejected();

    /*
     * Orders delivered in January of any year
     */
    @Query(value = "SELECT order_code, delivery_date FROM order WHERE MONTH(delivery_date) = 1", nativeQuery = true)
    List<Object[]> findAllOrderNotDelivInMonthJanaury();


    /*
     * How many orders are there in each status? Order the result in descending order by the number of orders.
     */
    @Query(value = "SELECT status, COUNT(*) AS total_orders " + //
            "FROM order " + //
            "GROUP BY status " + //
            "ORDER BY total_orders DESC", nativeQuery = true)
    List<Object[]> amountOrderState();


}
