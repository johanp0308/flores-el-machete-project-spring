package com.floreselmachetaso.jardineria.domain.service;


import java.util.List;
import java.util.Map;
public interface OrderService {

    List<Map<String, Object>> getFindAllStatusOrder();

    List<Map<String, Object>> getFindAllOrderDelivNotTime();

    List<Map<String, Object>> getFindAllOrderDelivNotTimeDiffTwoDay();

    List<Map<String, Object>> getFindAllOrderRejected();

    List<Map<String, Object>> getFindAllOrderNotDelivInMonthJanaury();

    List<Map<String, Object>> getAmountOrderState();
}
