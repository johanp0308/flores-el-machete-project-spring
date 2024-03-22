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
    public List<Map<String, Object>> getAveragePaymentYear() {
        List<Object[]> results = paymentRepository.averagePayYear();
        List<Map<String, Object>> averagePayments = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> paymentInfo = new HashMap<>();
            paymentInfo.put("average_payment_year", row[0]);
            averagePayments.add(paymentInfo);
        }

        return averagePayments;
    }

    @Override
    public List<Map<String, Object>> getEndDatePayForCustomer() {
        List<Object[]> results = paymentRepository.endDatePayForCustomer();
        List<Map<String, Object>> endDatePayments = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> paymentInfo = new HashMap<>();
            paymentInfo.put("customer_name", row[0]);
            paymentInfo.put("contact_name", row[1]);
            paymentInfo.put("contact_lastname", row[2]);
            paymentInfo.put("first_payment_date", row[3]);
            paymentInfo.put("last_payment_date", row[4]);
            endDatePayments.add(paymentInfo);
        }

        return endDatePayments;
    }

    @Override
    public List<Map<String, Object>> getsumTotalPaysAllYear() {
        List<Object[]> results = paymentRepository.sumTotalPaysAllYear();
        List<Map<String, Object>> sumTotalPaysAllYear = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> paymentInfo = new HashMap<>();
            paymentInfo.put("year", row[0]);
            paymentInfo.put("total_amount", row[1]);
            sumTotalPaysAllYear.add(paymentInfo);
        }

        return sumTotalPaysAllYear;
    }

    @Override
    public List<String> getfindAllPaymentMethodS() {
        List<Object[]> results = paymentRepository.findAllPaymentMethodS();
        List<String> paymentMethods = new ArrayList<>();

        for (Object[] row : results) {
            paymentMethods.add(String.valueOf(row[0]));
        }

        return paymentMethods;
    }

    @Override
    public List<Object[]> getfindAllPayPalYearOrderDesc() {
        return paymentRepository.findAllPayPalYearOrderDesc();
    }

    @Override
    public List<Object[]> getfindAllCustomerPayForYear() {
        return paymentRepository.findAllCustomerPayForYear();
    }





}
