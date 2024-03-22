package com.floreselmachetaso.jardineria.domain.service.impl;

import com.floreselmachetaso.jardineria.domain.repository.OrderRepository;
import com.floreselmachetaso.jardineria.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Map<String, Object>> getFindAllStatusOrder() {
        List<Object[]> results = orderRepository.findAllStatusOrder();
        List<Map<String, Object>> statusList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> statusInfo = new HashMap<>();
            statusInfo.put("estado", row[0]);
            statusList.add(statusInfo);
        }

        return statusList;
    }

    @Override
    public List<Map<String, Object>> getFindAllOrderDelivNotTime() {
        List<Object[]> results = orderRepository.findAllOrderDelivNotTime();
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("codigo_pedido", row[0]);
            orderInfo.put("codigo_cliente", row[1]);
            orderInfo.put("fecha_esperada", row[2]);
            orderInfo.put("fecha_entrega", row[3]);
            orderList.add(orderInfo);
        }

        return orderList;
    }

    @Override
    public List<Map<String, Object>> getFindAllOrderDelivNotTimeDiffTwoDay() {
        List<Object[]> results = orderRepository.findAllOrderDelivNotTimeDiffTwoDay();
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("codigo_pedido", row[0]);
            orderInfo.put("codigo_cliente", row[1]);
            orderInfo.put("fecha_esperada", row[2]);
            orderInfo.put("fecha_entrega", row[3]);
            orderList.add(orderInfo);
        }

        return orderList;
    }

    @Override
    public List<Map<String, Object>> getFindAllOrderRejected() {
        List<Object[]> results = orderRepository.findAllOrderRejected();
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("codigo_pedido", row[0]);
            orderInfo.put("fecha_pedido", row[1]);
            orderInfo.put("estado", row[2]);
            orderList.add(orderInfo);
        }

        return orderList;
    }

    @Override
    public List<Map<String, Object>> getFindAllOrderNotDelivInMonthJanaury() {
        List<Object[]> results = orderRepository.findAllOrderNotDelivInMonthJanaury();
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("codigo_pedido", row[0]);
            orderInfo.put("fecha_entrega", row[1]);
            orderList.add(orderInfo);
        }

        return orderList;
    }

    @Override
    public List<Map<String, Object>> getAmountOrderState() {
        List<Object[]> results = orderRepository.amountOrderState();
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("estado", row[0]);
            orderInfo.put("total_pedidos", row[1]);
            orderList.add(orderInfo);
        }

        return orderList;
    }
}
