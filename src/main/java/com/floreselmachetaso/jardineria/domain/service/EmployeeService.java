package com.floreselmachetaso.jardineria.domain.service;

import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;
import com.floreselmachetaso.jardineria.persistence.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmplyeWCodeBoss();

    List<EmployeeDTO> getBossEveryone();

    List<EmployeeDTO> getAllNotSalesRepresentative();

    List<EmployeeDTO> getAllEmployeeAndBoss();

    List<EmployeeDTO> getAllEmployeeAndBossAndBoss();

    List<EmployeeDTO> getAllEmployeeNotOffice();

    List<EmployeeDTO> getAllEmployeeNotCustomer();

    List<Object[]> getAllEmployeeNotCustomerAndOffice();

    List<Object[]> getAllEmployeeNotOfficeAndCustomer();

    List<Object[]> getAllEmployeeNotCustomerAndBoss();

    List<Object[]> countEmployee();

    List<Object[]> getEmployeeAndClients();

}
