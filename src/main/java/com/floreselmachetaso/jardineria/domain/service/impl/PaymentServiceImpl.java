package com.floreselmachetaso.jardineria.domain.service.impl;

import com.floreselmachetaso.jardineria.domain.repository.PaymentRepository;
import com.floreselmachetaso.jardineria.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Map<String, Object>> averagePayYear() {
        List<Object[]> results = paymentRepository.averagePayYear();
        List<Map<String,Object>> listas = new ArrayList<>();

        for(Object[] row: results){
            Map<String,Object> oMap = new HashMap<>();
            oMap.put("average_year",row[0]);
        }
        return listas;
    }

    @Override
    public List<Map<String, Object>> endDatePayForCustomer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endDatePayForCustomer'");
    }

    @Override
    public List<Map<String, Object>> amountCustomerDiffOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'amountCustomerDiffOrder'");
    }

    @Override
    public List<Map<String, Object>> sumAmountCustomerDiffOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sumAmountCustomerDiffOrder'");
    }

    @Override
    public List<Map<String, Object>> topProductsMoreSales() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topProductsMoreSales'");
    }
    
        
}
