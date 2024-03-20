package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    List<Map<String,Object>> averagePayYear();

    List<Map<String,Object>> endDatePayForCustomer();

    List<Map<String,Object>> amountCustomerDiffOrder();

    List<Map<String,Object>> sumAmountCustomerDiffOrder();

    List<Map<String,Object>> topProductsMoreSales();
}
