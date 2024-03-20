package com.floreselmachetaso.jardineria.web.controller;

import com.floreselmachetaso.jardineria.domain.service.ProductService;
import com.floreselmachetaso.jardineria.persistence.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/not-ordered")
    public ResponseEntity<List<ProductDTO>> getAllProductsNotOrder() {
        List<ProductDTO> products = productService.getAllProductsNotOrder();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/not-ordered-fields")
    public ResponseEntity<List<ProductDTO>> getAllProductsNotOrderFields() {
        List<ProductDTO> products = productService.getAllProductsNotOrderFields();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/expensive-cheap")
    public ResponseEntity<Map<String, Double>> getProductExpensiveAndCheap() {
        Map<String, Double> prices = productService.getProductExpensiveAndCheap();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}