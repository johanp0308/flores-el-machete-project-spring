package com.floreselmachetaso.jardineria.web.controller;


import com.floreselmachetaso.jardineria.domain.service.CustomerService;
import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/spain-customers")
    public List<CustomerDTO> getAllCustomersInSpain() {
        return customerService.getAllCustomerSpain();
    }

    @GetMapping("/byCityWithRepresentative")
    public List<CustomerDTO> getAllCustomersByCityWithRepresentative() {
        return customerService.getAllCustomerbyCityWRepresentIdOrId();
    }

    @GetMapping("/withSalesRepresentative")
    public List<Map<String, Object>> getAllCustomersWithSalesRepresentative() {
        return customerService.getAllCustomerWSalesRepres();
    }

    @GetMapping("/withSalesRepresentativeAndPayment")
    public List<Map<String, Object>> getAllCustomersWithSalesRepresentativeAndPayment() {
        return customerService.getAllCustomerWSalesRepresPay();
    }

    @GetMapping("/withSalesRepresentativePaymentAndCity")
    public List<Map<String, Object>> getAllCustomersWithSalesRepresentativePaymentAndCity() {
        return customerService.getAllCustomerWSalesRepresPayWCity();
    }

    @GetMapping("/withSalesRepresentativeNotPaymentAndCity")
    public List<Map<String, Object>> getAllCustomersWithSalesRepresentativeNoPaymentAndCity() {
        return customerService.getAllCustomerWSalesRepresNoPayWCity();
    }

    @GetMapping("/addressWithFuenlabradaCity")
    public List<CustomerDTO> getAllCustomersAddressWithCity() {
        return customerService.getAllCustomerAddressWCity();
    }

    @GetMapping("/withSalesRepresentativeAndCityOffice")
    public List<Map<String, Object>> getAllCustomersWithSalesRepresentativeAndCity() {
        return customerService.getAllCustomerAndSalesRepresWCity();
    }

    @GetMapping("/notDeliveredOnTime")
    public List<CustomerDTO> getAllCustomersNotDeliveredOnTime() {
        return customerService.getAllCustomerDeliveNotTime();
    }

    @GetMapping("/rangesOfPayment")
    public List<Map<String, Object>> getAllRangesOfPayment() {
        return customerService.getAllRangesPayACustomer();
    }

    @GetMapping("/noPayment")
    public List<CustomerDTO> getAllCustomersNoPayment() {
        return customerService.getAllCustomerNoPay();
    }

    @GetMapping("/noOrder")
    public List<CustomerDTO> getAllCustomersNoOrder() {
        return customerService.getAllCustomerNoOrder();
    }

    @GetMapping("/noPaymentNoOrder")
    public List<CustomerDTO> getAllCustomersNoPaymentNoOrder() {
        return customerService.getAllCustomerNoPayNoOrder();
    }

    @GetMapping("/orderNoPayment")
    public List<CustomerDTO> getAllCustomersOrderNoPayment() {
        return customerService.getAllCustomerWOrderNotPay();
    }

    @GetMapping("/amountByCountry")
    public List<Map<String, Object>> getAmountCustomerByCountry() {
        return customerService.amountCustomerCountry();
    }

    @GetMapping("/totalCustomers")
    public List<Map<String, Object>> getTotalCustomers() {
        return customerService.numberCustomerOfCompany();
    }

    @GetMapping("/amountByCity")
    public List<Map<String, Object>> getAmountCustomerByCity() {
        return customerService.amountCustomerByCity();
    }

    @GetMapping("/searchByCityStart")
    public List<Map<String, Object>> searchCustomerByCityStart() {
        return customerService.searchCustomerByCityStart();
    }

    @GetMapping("/noSalesRepresentative")
    public List<Map<String, Object>> getAmountCustomerNoSalesRepresentative() {
        return customerService.amountCustomerNotSalesRepres();
    }
}