package com.floreselmachetaso.jardineria.web.controller;

import com.floreselmachetaso.jardineria.domain.service.PaymentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payments")
@SecurityRequirement(name = "bearerAuth")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/averagePaymentYear")
    public List<Map<String, Object>> getAveragePaymentYear() {
        return paymentService.getAveragePaymentYear();
    }

    @GetMapping("/endDatePayForCustomer")
    public List<Map<String, Object>> getEndDatePayForCustomer() {
        return paymentService.getEndDatePayForCustomer();
    }

    @GetMapping("/sumTotalPaysAllYear")
    public List<Map<String, Object>> getSumTotalPaysAllYear() {
        return paymentService.getsumTotalPaysAllYear();
    }

    @GetMapping("/findAllPaymentMethods")
    public List<String> findAllPaymentMethods() {
        return paymentService.getfindAllPaymentMethodS();
    }

    @GetMapping("/findAllPayPalYearOrderDesc")
    public List<Object[]> findAllPayPalYearOrderDesc() {
        return paymentService.getfindAllPayPalYearOrderDesc();
    }

    @GetMapping("/findAllCustomerPayForYear")
    public List<Object[]> findAllCustomerPayForYear() {
        return paymentService.getfindAllCustomerPayForYear();
    }
}