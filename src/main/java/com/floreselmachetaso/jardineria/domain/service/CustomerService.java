package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;
import java.util.Map;

import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;

public interface CustomerService {
    
    List<CustomerDTO> getAllCustomerSpain();
    List<CustomerDTO> getAllCustomerbyCityWRepresentIdOrId();
    List<Map<String,Object>> getAllCustomerWSalesRepres();
    List<Map<String,Object>> getAllCustomerWSalesRepresPay();
    List<Map<String,Object>> getAllCustomerWSalesRepresPayWCity();
    List<Map<String,Object>> getAllCustomerWSalesRepresNoPayWCity();
    List<CustomerDTO> getAllCustomerAddressWCity();
    List<Map<String,Object>> getAllCustomerAndSalesRepresWCity();
    List<CustomerDTO> getAllCustomerDeliveNotTime();
    List<Map<String,Object>> getAllRangesPayACustomer();
    List<CustomerDTO> getAllCustomerNoPay();
    List<CustomerDTO> getAllCustomerNoOrder();
    List<CustomerDTO> getAllCustomerNoPayNoOrder();
    List<CustomerDTO> getAllCustomerWOrderNotPay();
    List<Map<String,Object>> amountCustomerCountry();
    List<Map<String,Object>> numberCustomerOfCompany();
    List<Map<String,Object>> amountCustomerByCity();
    List<Map<String,Object>> searchCustomerByCityStart();
    List<Map<String,Object>> amountCustomerNotSalesRepres();
}
