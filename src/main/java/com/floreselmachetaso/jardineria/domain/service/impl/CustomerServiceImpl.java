package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floreselmachetaso.jardineria.domain.repository.CustomerRepository;
import com.floreselmachetaso.jardineria.domain.service.CostumerService;
import com.floreselmachetaso.jardineria.persistence.DTO.CustomerDTO;

@Service
public class CustomerServiceImpl implements CostumerService{
    
    
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
            cDto.setCity(String.valueOf(ele[0]));
            cDto.setPhone(String.valueOf(ele[1]));
            return cDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getAllCustomerbyCityWRepresentIdOrId() {
        List<Object[]> listas =  customerRepository.findAllCustomerbyCityWRepresentIdOrId();
        return (List<CustomerDTO>) listas.stream().map(ele ->{
            CustomerDTO cDto = new CustomerDTO();
            cDto.setCustomerCode(Integer.valueOf(ele[0].toString()));
            cDto.setCustomerName(String.valueOf(ele[1]).toString());
            cDto.setContactName(String.valueOf(ele[2].toString()));
            cDto.setContactLastName(String.valueOf(ele[3].toString()));
            cDto.setPhone(String.valueOf(ele[4].toString()));
            cDto.setFax(String.valueOf(ele[5].toString()));
            cDto.setAddressLine1(String.valueOf(ele[6]));
            cDto.setAddressLine2(String.valueOf(ele[7]));
            cDto.setCity(String.valueOf(ele[8].toString()));
            cDto.setRegion(String.valueOf(ele[9].toString()));
            cDto.setCountry(String.valueOf(ele[10].toString()));
            cDto.setPostalCode(String.valueOf(ele[11].toString()));
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
            result.put("nombre",row[1]);
            result.put("apellido1", row[2]);
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

    



}
