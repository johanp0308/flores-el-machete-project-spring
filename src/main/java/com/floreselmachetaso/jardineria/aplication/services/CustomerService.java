package com.floreselmachetaso.jardineria.aplication.services;

import com.floreselmachetaso.jardineria.aplication.repository.CustomerRepository;
import com.floreselmachetaso.jardineria.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public List<Optional<Customer>> getOneCustomer(Integer id){
        return (List) customerRepository.findAll();
    }
}