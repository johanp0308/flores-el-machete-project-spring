package com.floreselmachetaso.jardineria.domain.service.impl;

import com.floreselmachetaso.jardineria.domain.repository.PaymentRepository;
import com.floreselmachetaso.jardineria.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

@Autowired
private PaymentRepository paymentRepository;
    @Override
    public List<Object[]> averagePayYear() {
        return null;
    }

    @Override
    public List<Object[]> endDatePayForCustomer() {
        return null;
    }

    @Override
    public List<Object[]> amountCustomerDiffOrder() {
        return null;
    }

    @Override
    public List<Object[]> sumAmountCustomerDiffOrder() {
        return null;
    }

    @Override
    public List<Object[]> topProductsMoreSales() {
        return null;
    }
}
