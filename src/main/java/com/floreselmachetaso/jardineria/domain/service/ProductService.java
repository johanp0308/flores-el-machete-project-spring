package com.floreselmachetaso.jardineria.domain.service;

import com.floreselmachetaso.jardineria.persistence.DTO.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDTO> getAllProductsNotOrder();

    List<ProductDTO> getAllProductsNotOrderFields();

    Map<String, Double> getProductExpensiveAndCheap();
}
