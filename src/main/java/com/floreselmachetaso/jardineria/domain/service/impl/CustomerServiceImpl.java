package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floreselmachetaso.jardineria.domain.repository.CustomerRepository;
import com.floreselmachetaso.jardineria.domain.service.CustomerService;
import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomerSpain() {
        List<Object[]> lista = customerRepository.findAllCustomerSpain();
        return (List<CustomerDTO>) lista.stream().map(ele -> {
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerName(String.valueOf(ele[0]));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getAllCustomerbyCityWRepresentIdOrId() {
        List<Object[]> listas =  customerRepository.findAllCustomerbyCityWRepresentIdOrId();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]));
            cDto.setContactName(String.valueOf(ele[2]));
            cDto.setContactLastName(String.valueOf(ele[3]));
            cDto.setPhone(String.valueOf(ele[4]));
            cDto.setFax(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8]));
            cDto.setRegion(String.valueOf(ele[9]));
            cDto.setCountry(String.valueOf(ele[10]));
            cDto.setPostalCode(String.valueOf(ele[11]));
            cDto.setSalesRepresentativeEmployee(Integer.valueOf(ele[12].toString()));
            cDto.setCreditLimit(Double.valueOf(ele[13].toString()));
            return cDto; 
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String,Object>> getAllCustomerWSalesRepres() {
        List<Object[]> listas  = customerRepository.findAllCustomerWSalesRepres();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nomre_cliente", row[0]);
            result.put("nombre_representante",row[1]);
            result.put("apellido_representante", row[2]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String,Object>> getAllCustomerWSalesRepresPay() {
        List<Object[]> listas  = customerRepository.findAllCustomerWSalesRepresPay();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nomre_cliente", row[0]);
            result.put("nombre_representante",row[1]);
            result.put("apellido_representante", row[2]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String,Object>> getAllCustomerWSalesRepresPayWCity() {
        List<Object[]> listas  = customerRepository.findAllCustomerWSalesRepresPayWCity();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nomre_cliente", row[0]);
            result.put("nombre_representante",row[1]);
            result.put("apellido_representante", row[2]);
            result.put("ciudad", row[3]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String,Object>> getAllCustomerWSalesRepresNoPayWCity() {
        List<Object[]> listas  = customerRepository.findAllCustomerWSalesRepresNoPayWCity();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nomre_cliente", row[0]);
            result.put("nombre_representante",row[1]);
            result.put("apellido_representante", row[2]);
            result.put("ciudad", row[3]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<CustomerDTO> getAllCustomerAddressWCity() {
        List<Object[]> lista = customerRepository.findAllCustomerAddressWCity();
        return (List<CustomerDTO>) lista.stream().map(ele -> {
            CustomerDTO cDto = new CustomerDTO();
            cDto.setAddressLine1(String.valueOf(ele[0]));
            cDto.setAddressLine2((String.valueOf(ele[1])));
            cDto.setCity(String.valueOf(ele[2]));
            cDto.setCountry(String.valueOf(ele[3]));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getAllCustomerAndSalesRepresWCity() {
        List<Object[]> listas  = customerRepository.findAllCustomerAndSalesRepresWCity();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nomre_cliente", row[0]);
            result.put("nombre_representante",row[1]);
            result.put("apellido_representante", row[2]);
            result.put("ciudad", row[3]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<CustomerDTO> getAllCustomerDeliveNotTime() {
        List<Object[]> lista = customerRepository.findAllCustomerDeliveNotTime();
        return (List<CustomerDTO>) lista.stream().map(ele -> {
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerName((String.valueOf(ele[0])));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getAllRangesPayACustomer() {
        List<Object[]> listas  = customerRepository.findAllRangesPayACustomer();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("nombre_cliente", row[0]);
            result.put("gamas_compradas", row[1]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<CustomerDTO> getAllCustomerNoPay() {
        List<Object[]> listas =  customerRepository.findAllCustomerNoPay();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]));
            cDto.setContactName(String.valueOf(ele[2]));
            cDto.setContactLastName(String.valueOf(ele[3]));
            cDto.setPhone(String.valueOf(ele[4]));
            cDto.setFax(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8]));
            cDto.setRegion(String.valueOf(ele[9]));
            cDto.setCountry(String.valueOf(ele[10]));
            cDto.setPostalCode(String.valueOf(ele[11]));
            cDto.setSalesRepresentativeEmployee(Integer.valueOf(ele[12].toString()));
            cDto.setCreditLimit(Double.valueOf(ele[13].toString()));
            System.out.println(cDto);
            return cDto; 
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getAllCustomerNoOrder() {
        List<Object[]> listas =  customerRepository.findAllCustomerNoOrder();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]));
            cDto.setContactName(String.valueOf(ele[2]));
            cDto.setContactLastName(String.valueOf(ele[3]));
            cDto.setPhone(String.valueOf(ele[4]));
            cDto.setFax(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8]));
            cDto.setRegion(String.valueOf(ele[9]));
            cDto.setCountry(String.valueOf(ele[10]));
            cDto.setPostalCode(String.valueOf(ele[11]));
            cDto.setSalesRepresentativeEmployee(Integer.valueOf(ele[12].toString()));
            cDto.setCreditLimit(Double.valueOf(ele[13].toString()));
            return cDto; 
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getAllCustomerNoPayNoOrder() {
        List<Object[]> listas =  customerRepository.findAllCustomerNoPayNoOrder();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]));
            cDto.setContactName(String.valueOf(ele[2]));
            cDto.setContactLastName(String.valueOf(ele[3]));
            cDto.setPhone(String.valueOf(ele[4]));
            cDto.setFax(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8]));
            cDto.setRegion(String.valueOf(ele[9]));
            cDto.setCountry(String.valueOf(ele[10]));
            cDto.setPostalCode(String.valueOf(ele[11]));
            cDto.setSalesRepresentativeEmployee(Integer.valueOf(ele[12].toString()));
            cDto.setCreditLimit(Double.valueOf(ele[13].toString()));
            return cDto; 
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getAllCustomerWOrderNotPay() {
        List<Object[]> listas =  customerRepository.findAllCustomerWOrderNotPay();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]));
            cDto.setContactName(String.valueOf(ele[2]));
            cDto.setContactLastName(String.valueOf(ele[3]));
            cDto.setPhone(String.valueOf(ele[4]));
            cDto.setFax(String.valueOf(ele[5]));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8]));
            cDto.setRegion(String.valueOf(ele[9]));
            cDto.setCountry(String.valueOf(ele[10]));
            cDto.setPostalCode(String.valueOf(ele[11]));
            cDto.setSalesRepresentativeEmployee(Integer.valueOf(ele[12].toString()));
            cDto.setCreditLimit(Double.valueOf(ele[13].toString()));
            return cDto; 
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> amountCustomerCountry() {
        List<Object[]> listas  = customerRepository.amountCustomerCountry();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("pais", row[0]);
            result.put("total_clientes",row[1]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String, Object>> numberCustomerOfCompany() {
        List<Object[]> listas  = customerRepository.numberCustomerOfCompany();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("total_clientes", row[0]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String, Object>> amountCustomerByCity() {
        List<Object[]> listas  = customerRepository.amountCustomerByCity();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("total_clientes_madrid", row[0]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String, Object>> searchCustomerByCityStart() {
        List<Object[]> listas  = customerRepository.searchCustomerByCityStart();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("ciudad", row[0]);
            result.put("total_clientes", row[1]);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<Map<String, Object>> amountCustomerNotSalesRepres() {
        List<Object[]> listas  = customerRepository.amountCustomerNotSalesRepres();
        List<Map<String,Object>> results = new ArrayList<>();
        for(Object[] row : listas){
            Map<String,Object> result = new HashMap<>();
            result.put("total_clientes", row[0]);
            results.add(result);
        }
        return results;
    }



}
