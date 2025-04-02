package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.dto.ProductDto;

public interface ProductService {
    public Product addProduct(ProductDto productDto);
    public Product updateProduct(Long productId, ProductDto productDto);
    public void softDeleteProduct(Long productId);
}
