package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;

public interface PaymentService {

    List<Object[]> averagePayYear();

    List<Object[]> endDatePayForCustomer();

    List<Object[]> amountCustomerDiffOrder();

    List<Object[]> sumAmountCustomerDiffOrder();

    List<Object[]> topProductsMoreSales();
}
