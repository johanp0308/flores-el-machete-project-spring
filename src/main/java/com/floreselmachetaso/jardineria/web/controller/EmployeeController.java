package com.floreselmachetaso.jardineria.web.controller;

import com.floreselmachetaso.jardineria.domain.service.EmployeeService;
import com.floreselmachetaso.jardineria.persistence.DTO.EmployeeDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all-with-code-boss")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesWithCodeBoss() {
        List<EmployeeDTO> employees = employeeService.getAllEmplyeWCodeBoss();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/boss-everyone")
    public ResponseEntity<List<EmployeeDTO>> getBossEveryone() {
        List<EmployeeDTO> bossList = employeeService.getBossEveryone();
        return new ResponseEntity<>(bossList, HttpStatus.OK);
    }

    @GetMapping("/not-sales-representative")
    public ResponseEntity<List<EmployeeDTO>> getAllNotSalesRepresentative() {
        List<EmployeeDTO> employees = employeeService.getAllNotSalesRepresentative();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/all-with-boss")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeAndBoss() {
        List<EmployeeDTO> employees = employeeService.getAllEmployeeAndBoss();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/all-with-boss-and-boss")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeAndBossAndBoss() {
        List<EmployeeDTO> employees = employeeService.getAllEmployeeAndBossAndBoss();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/not-office")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeNotOffice() {
        List<EmployeeDTO> employees = employeeService.getAllEmployeeNotOffice();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/not-customer")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeNotCustomer() {
        List<EmployeeDTO> employees = employeeService.getAllEmployeeNotCustomer();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/not-customer-with-office")
    public ResponseEntity<List<Object[]>> getAllEmployeeNotCustomerWithOffice() {
        List<Object[]> employees = employeeService.getAllEmployeeNotCustomerAndOffice();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/not-office-not-customer")
    public ResponseEntity<List<Object[]>> getAllEmployeeNotOfficeAndCustomer() {
        List<Object[]> employees = employeeService.getAllEmployeeNotOfficeAndCustomer();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/not-customer-and-boss")
    public ResponseEntity<List<Object[]>> getAllEmployeeNotCustomerAndBoss() {
        List<Object[]> employees = employeeService.getAllEmployeeNotCustomerAndBoss();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/count-employee")
    public ResponseEntity<List<Object[]>> countEmployee() {
        List<Object[]> countList = employeeService.countEmployee();
        return new ResponseEntity<>(countList, HttpStatus.OK);
    }

    @GetMapping("/employee-clients")
    public ResponseEntity<List<Object[]>> getEmployeeAndClients() {
        List<Object[]> employeeClientsList = employeeService.getEmployeeAndClients();
        return new ResponseEntity<>(employeeClientsList, HttpStatus.OK);
    }
}
