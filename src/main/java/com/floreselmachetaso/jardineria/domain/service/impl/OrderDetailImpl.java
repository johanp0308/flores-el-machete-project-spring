package com.floreselmachetaso.jardineria.domain.service.impl;

import com.floreselmachetaso.jardineria.domain.repository.OrderDetailRepository;
import com.floreselmachetaso.jardineria.domain.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderDetailImpl implements OrderDetailService {


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Map<String, Object>> getFindAllSalesByPrice() {
        List<Object[]> results = orderDetailRepository.findAllSalesByPrice();
        List<Map<String, Object>> salesByPrice = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> saleInfo = new HashMap<>();
            saleInfo.put("nombre_producto", row[0]);
            saleInfo.put("unidades_vendidas", row[1]);
            saleInfo.put("total_facturado_sin_iva", row[2]);
            saleInfo.put("total_facturado_con_iva", row[3]);
            salesByPrice.add(saleInfo);
        }

        return salesByPrice;
    }

    @Override
    public List<Map<String, Object>> getTopProductsMoreSales() {
        List<Object[]> results = orderDetailRepository.topProductsMoreSales();
        List<Map<String, Object>> topProducts = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> productInfo = new HashMap<>();
            productInfo.put("codigo_producto", row[0]);
            productInfo.put("nombre_producto", row[1]);
            productInfo.put("total_unidades_vendidas", row[2]);
            topProducts.add(productInfo);
        }

        return topProducts;
    }

    @Override
    public List<Map<String, Object>> getAmountCustomerDiffOrder() {
        List<Object[]> results = orderDetailRepository.amountCustomerDiffOrder();
        List<Map<String, Object>> amountCustomerDiffOrders = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("codigo_pedido", row[0]);
            orderInfo.put("num_productos_diferentes", row[1]);
            amountCustomerDiffOrders.add(orderInfo);
        }

        return amountCustomerDiffOrders;
    }

    @Override
    public List<Map<String, Object>> getBillingCompany() {
        List<Object[]> results = orderDetailRepository.billingCompany();
        List<Map<String, Object>> billingCompany = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> companyInfo = new HashMap<>();
            companyInfo.put("base_imponible", row[0]);
            companyInfo.put("iva", row[1]);
            companyInfo.put("total_facturado", row[2]);
            billingCompany.add(companyInfo);
        }

        return billingCompany;
    }

    @Override
    public List<Map<String, Object>> getBillingCompanyByProduct() {
        List<Object[]> results = orderDetailRepository.billingCompanyByProduct();
        List<Map<String, Object>> billingCompanyByProduct = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> productInfo = new HashMap<>();
            productInfo.put("codigo_producto", row[0]);
            productInfo.put("base_imponible", row[1]);
            productInfo.put("iva", row[2]);
            productInfo.put("total_facturado", row[3]);
            billingCompanyByProduct.add(productInfo);
        }

        return billingCompanyByProduct;
    }


}
