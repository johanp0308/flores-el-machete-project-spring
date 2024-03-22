package com.floreselmachetaso.jardineria.web.controller;

import com.floreselmachetaso.jardineria.domain.service.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/status")
    public List<Map<String, Object>> findAllStatusOrder() {
        return orderService.getFindAllStatusOrder();
    }

    @GetMapping("/not-delivered")
    public List<Map<String, Object>> findAllOrderDelivNotTime() {
        return orderService.getFindAllOrderDelivNotTime();
    }

    @GetMapping("/not-delivered/diff-two-day")
    public List<Map<String, Object>> findAllOrderDelivNotTimeDiffTwoDay() {
        return orderService.getFindAllOrderDelivNotTimeDiffTwoDay();
    }

    @GetMapping("/rejected")
    public List<Map<String, Object>> findAllOrderRejected() {
        return orderService.getFindAllOrderRejected();
    }

    @GetMapping("/not-delivered/january")
    public List<Map<String, Object>> findAllOrderNotDelivInMonthJanaury() {
        return orderService.getFindAllOrderNotDelivInMonthJanaury();
    }

    @GetMapping("/amount-state")
    public List<Map<String, Object>> amountOrderState() {
        return orderService.getAmountOrderState();
    }
}