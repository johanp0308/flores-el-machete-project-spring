package com.floreselmachetaso.jardineria.domain.service;

import java.util.Map;
import java.util.List;

public interface OrderDetailService {
    List<Map<String, Object>> getFindAllSalesByPrice();

    List<Map<String, Object>> getTopProductsMoreSales();

    List<Map<String, Object>> getAmountCustomerDiffOrder();

    List<Map<String, Object>> getBillingCompany();

    List<Map<String, Object>> getBillingCompanyByProduct();
}
