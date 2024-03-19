package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;
import java.util.Map;

import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;
import com.floreselmachetaso.jardineria.persistence.entities.Customer;

public interface CustomerService {
    
    List<CustomerDTO> getAllCustomerSpain();
    List<CustomerDTO> getAllCustomerbyCityWRepresentIdOrId();
    List<Map<String,Object>> getAllCustomerWSalesRepres();
    List<Map<String,Object>> getAllCustomerWSalesRepresPay();
    List<Map<String,Object>> getAllCustomerWSalesRepresPayWCity();
    List<Map<String,Object>> getAllCustomerWSalesRepresNoPayWCity();
    List<CustomerDTO> getAllCustomerAddressWCity();
}
