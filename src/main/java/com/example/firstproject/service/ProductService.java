package com.example.firstproject.service;

import com.example.firstproject.data.dto.ProductDto;

// loose coupling
public interface ProductService {
    // database애 저장
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    // 조회
    ProductDto getProduct(String productId);
}
