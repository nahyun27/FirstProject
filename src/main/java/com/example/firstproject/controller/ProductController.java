package com.example.firstproject.controller;

import com.example.firstproject.data.dto.ProductDto;
import com.example.firstproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product-api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto createProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @GetMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }
    @DeleteMapping(value = "/product/{productId}")
    public  ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

}
