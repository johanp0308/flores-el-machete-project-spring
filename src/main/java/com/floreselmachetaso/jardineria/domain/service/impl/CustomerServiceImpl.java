package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.List;
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


}
