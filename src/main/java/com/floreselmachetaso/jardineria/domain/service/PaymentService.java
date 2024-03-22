package com.floreselmachetaso.jardineria.domain.service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    List<Map<String, Object>> getAveragePaymentYear();

    List<Map<String, Object>> getEndDatePayForCustomer();

    List<Map<String,Object>> getsumTotalPaysAllYear();

    List<String> getfindAllPaymentMethodS();

    List<Object[]> getfindAllPayPalYearOrderDesc();

    List<Object[]> getfindAllCustomerPayForYear();
}
