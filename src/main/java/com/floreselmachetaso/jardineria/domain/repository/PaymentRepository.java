package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.floreselmachetaso.jardineria.persistence.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    /*
     * What was the average payment in 2009?
     */
    @Query(value = "SELECT AVG(total) AS average_payment_year  " + //
            "FROM payment  " + //
            "WHERE YEAR(payment_date) = 2009", nativeQuery = true)
    List<Object[]> averagePayYear();

    /*
     * Calculate the date of the first and last payment made by each of the clients. The list should show the name and last names of each client.
     */
    @Query(value = "SELECT  " + //
            "    c.customer_name,  " + //
            "    c.contact_name,  " + //
            "    c.contact_lastname, " + //
            "    MIN(p.payment_date) AS first_payment_date, " + //
            "    MAX(p.payment_date) AS last_payment_date " + //
            "FROM  " + //
            "    customer c " + //
            "LEFT JOIN  " + //
            "    payment p ON c.customer_code = p.customer_code " + //
            "GROUP BY  " + //
            "    c.customer_code,  " + //
            "    c.customer_name,  " + //
            "    c.contact_name,  " + //
            "    c.contact_lastname", nativeQuery = true)
    List<Object[]> endDatePayForCustomer();

    /*
     * Show the total sum of all payments made for each of the years that appear in the payment table.
     */
    @Query(value = "SELECT YEAR(payment_date) AS year, SUM(total) AS total_sum_payments " + //
            "FROM payment " + //
            "GROUP BY YEAR(payment_date)", nativeQuery = true)
    List<Object[]> sumTotalPaysAllYear();

    /*
     * Returns a list with all the payment methods that appear in the payment table. Note that duplicate payment methods should not appear.
     */

    @Query(value = "SELECT DISTINCT payment_method FROM payment", nativeQuery = true)
    List<Object[]> findAllPaymentMethods();

    /*
     * Returns a list with all the payments made in the year 2008 using PayPal. Sort the result from highest to lowest.
     */
    @Query(value = "SELECT * FROM payment WHERE YEAR(payment_date) = 2008 AND payment_method = 'Paypal' ORDER BY total DESC", nativeQuery = true)
    List<Object[]> findAllPayPalYearOrderDesc();

    /*
     * Returns a list with the customer codes of those customers who made any payment in 2008. Note that you should eliminate those customer codes that appear duplicated.
     */
    @Query(value = "SELECT DISTINCT customer_code FROM payment WHERE YEAR(payment_date) = 2008", nativeQuery = true)
    List<Object[]> findAllCustomersPayForYear();


}
