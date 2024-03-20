package com.floreselmachetaso.jardineria.domain.service;

import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;
import com.floreselmachetaso.jardineria.persistence.entities.Employee;

import java.util.List;

public interface EmployeeService {

    /*
     * Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
     */
    List<EmployeeDTO> getAllEmplyeWCodeBoss();

    /*
     * Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa
     */
    List<EmployeeDTO> getBossEveryone();

    /*
     * Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
     */
    List<EmployeeDTO> getAllNotSalesRepresentative();


    /*
     * Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
     */

    List<EmployeeDTO> getAllEmployeeAndBoss();

    /*
     * Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
     */

    List<EmployeeDTO> getAllEmployeeAndBossAndBoss();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
     */

    List<EmployeeDTO> getAllEmployeeNotOffice();


    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
     */

    List<EmployeeDTO> getAllEmployeeNotCustomer();

    /*
     * Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
     */
    List<Object[]> getAllEmployeeNotCustomerAndOffice();


    /*
     * Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
     */

    List<Object[]> getAllEmployeeNotOfficeAndCustomer();


    /*
     * Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
     */

    List<Object[]> getAllEmployeeNotCustomerAndBoss();

    /*
     * ¿Cuántos empleados hay en la compañía?
     */

    List<Object[]> countEmployee();

    /*
     * Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
     */

    List<Object[]> getEmployeeAndClients();



}
