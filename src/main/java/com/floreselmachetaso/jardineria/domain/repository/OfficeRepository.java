package com.floreselmachetaso.jardineria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String>  {

    /*
     * List of offices by code and city
     */
    @Query(value = "SELECT office_code as Code, city as City FROM office", nativeQuery = true)
    List<Object[]> findAllOfficeWCity();

    /*
     * List of offices in Spain with city and telephone
     */
    @Query(value = "SELECT city as City, phone as Telephone FROM office WHERE country LIKE 'Spain'", nativeQuery = true)
    List<Object[]> findAllWOfficeWCountry();

    /*
     * List of offices in Spain with city and telephone
     *  */
    @Query(value = "SELECT * FROM office WHERE office_code NOT IN ( " + //
            "    SELECT DISTINCT e.office_code " + //
            "    FROM employee e " + //
            "    JOIN customer c ON e.employee_code = c.employee_code_sales_rep " + //
            "    JOIN order o ON c.customer_code = o.customer_code " + //
            "    JOIN order_detail od ON o.order_code = od.order_code " + //
            "    JOIN product p ON od.product_code = p.product_code " + //
            "    WHERE p.line = 'Fruits'" + //
            ")", nativeQuery = true)
    List<Object[]> findAllOfficeWEmployeWCustomerPayAGamaFrut();

}
