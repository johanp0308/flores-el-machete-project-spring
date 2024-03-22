package com.floreselmachetaso.jardineria.web.controller;


import com.floreselmachetaso.jardineria.domain.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/sales-by-price")
    public List<Map<String, Object>> getSalesByPrice() {
        return orderDetailService.getFindAllSalesByPrice();
    }

    @GetMapping("/top-products-more-sales")
    public List<Map<String, Object>> getTopProductsMoreSales() {
        return orderDetailService.getTopProductsMoreSales();
    }

    @GetMapping("/amount-customer-diff-order")
    public List<Map<String, Object>> getAmountCustomerDiffOrder() {
        return orderDetailService.getAmountCustomerDiffOrder();
    }

    @GetMapping("/billing-company")
    public List<Map<String, Object>> getBillingCompany() {
        return orderDetailService.getBillingCompany();
    }

    @GetMapping("/billing-company-by-product")
    public List<Map<String, Object>> getBillingCompanyByProduct() {
        return orderDetailService.getBillingCompanyByProduct();
    }
}