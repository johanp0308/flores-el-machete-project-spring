package com.floreselmachetaso.jardineria.domain.repository;


import java.util.List;

import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.floreselmachetaso.jardineria.persistence.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /*
     * Employees whose boss has a boss code equal to 7 with name, last name, and email.
     */
    @Query(value = "SELECT  employee_code, name, lastname1, lastname2, email, boss_code FROM employee WHERE boss_code = 7", nativeQuery = true)
    List<Object[]> findAllEmplyeWCodeBoss();

    /*
     * Position name, name, last name, and email of the company's boss.
     */
    @Query(value = "SELECT position, name, lastname1, lastname2, email FROM employee WHERE boss_code IS NULL", nativeQuery = true)
    List<Object[]> findBossEvryOne();

    /*
     * Position name, name, last name, and email of employees who are not Sales Representatives.
     */
    @Query(value = "SELECT name, lastname1, lastname2, position FROM employee WHERE position NOT LIKE 'Sales Representative'", nativeQuery = true)
    List<Object[]> findAllNotSalesRepresentative();

    /*
     * Name of each employee, name of their boss.
     */
    @Query(value = "SELECT e1.name AS employee_name, e2.name AS boss_name FROM employee AS e1 LEFT JOIN employee AS e2 ON e1.boss_code = e2.employee_code", nativeQuery = true)
    List<Object[]> findAllEmployeeAndBoss();

    /*
     * Name of each employee, name of their boss, and name of their boss's boss.
     */
    @Query(value = "SELECT e1.name AS employee_name, e2.name AS boss_name, e3.name AS boss_boss_name FROM employee AS e1 LEFT JOIN employee AS e2 ON e1.boss_code = e2.employee_code LEFT JOIN employee AS e3 ON e2.boss_code = e3.employee_code", nativeQuery = true)
    List<Object[]> findAllEmployeeAndBossAndBoss();

    /*
     * Employees without an associated office.
     */
    @Query(value = "SELECT * FROM employee WHERE office_code IS NULL", nativeQuery = true)
    List<Object[]> findAllEmployeeNotOffice();

    /*
     * Employees without an associated customer.
     */
    @Query(value = "SELECT * FROM employee WHERE employee_code NOT IN (SELECT DISTINCT employee_code_sales_rep FROM customer)", nativeQuery = true)
    List<Object[]> findAllEmployeeNotCustomer();

    /*
     * Employees without an associated customer along with the data of the office they work in.
     */
    @Query(value = "SELECT e.*, o.* FROM employee AS e LEFT JOIN office AS o ON e.office_code = o.office_code WHERE e.employee_code NOT IN (SELECT DISTINCT employee_code_sales_rep FROM customer)", nativeQuery = true)
    List<Object[]> findAllEmployeeNotCustomerWDataOffice();

    /*
     * Returns a list showing employees without an associated office and those without an associated customer.
     */
    @Query(value = "SELECT * FROM employee WHERE office_code IS NULL UNION SELECT e.* FROM employee e LEFT JOIN customer c ON e.employee_code = c.employee_code_sales_rep WHERE c.customer_code IS NULL", nativeQuery = true)
    List<Object[]> findAllEmployeeNotOfficeANotCustomer();

    /*
     * Returns a list with the data of employees who do not have associated customers and the name of their associated boss.
     */
    @Query(value = "SELECT e1.*, e2.name AS boss_name, e2.lastname1 AS boss_lastname FROM employee AS e1 LEFT JOIN employee AS e2 ON e1.boss_code = e2.employee_code WHERE e1.employee_code NOT IN (SELECT DISTINCT employee_code_sales_rep FROM customer)", nativeQuery = true)
    List<Object[]> findAllDataEmployeNotCustomerAndBoss();

    /*
     * How many employees are there in the company?
     */
    @Query(value = "SELECT COUNT(*) AS total_employees FROM employee", nativeQuery = true)
    List<Object[]> amountEmployee();

    /*
     * Returns the name of the sales representatives and the number of customers each one serves.
     */
    @Query(value = "SELECT e.name, e.lastname1, COUNT(c.customer_code) AS total_customers FROM employee AS e LEFT JOIN customer AS c ON e.employee_code = c.employee_code_sales_rep GROUP BY e.employee_code, e.name, e.lastname1", nativeQuery = true)
    List<Object[]> findAllSalesRepresandNumberCustomer();

    
}