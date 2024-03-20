package com.floreselmachetaso.jardineria.domain.service.impl;


import com.floreselmachetaso.jardineria.domain.repository.ProductRepository;
import com.floreselmachetaso.jardineria.domain.service.ProductService;
import com.floreselmachetaso.jardineria.persistence.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<ProductDTO> getAllProductsNotOrder() {
        return productRepository.findAllProductsNotOrder().stream()
                .map(row -> {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProductCode((String) row[0]);
                    productDTO.setName((String) row[1]);
                    productDTO.setProductLine((String) row[2]);
                    productDTO.setDimensions((String) row[3]);
                    productDTO.setSupplier((String) row[4]);
                    productDTO.setDescription((String) row[5]);
                    productDTO.setQuantityInStock((Integer) row[6]);
                    productDTO.setSalePrice((Double) row[7]);
                    productDTO.setSupplierPrice((Double) row[8]);
                    return productDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsNotOrderFields() {
        return productRepository.findAllProductsNotOrderFields().stream()
                .map(row -> {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setName((String) row[0]);
                    productDTO.setDescription((String) row[1]);
                    productDTO.setImage((String) row[2]);
                    return productDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getProductExpensiveAndCheap() {
        List<Object[]> result = productRepository.productExpensiveAndCheap();

        // Inicializamos los precios con valores extremos para que puedan ser reemplazados
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;

        // Iteramos sobre los resultados para encontrar el precio más caro y el más barato
        for (Object[] row : result) {
            double price = (Double) row[1];
            maxPrice = Math.max(maxPrice, price);
            minPrice = Math.min(minPrice, price);
        }

        // Creamos un mapa para almacenar los resultados
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("maxPrice", maxPrice);
        priceMap.put("minPrice", minPrice);

        return priceMap;
    }
}
