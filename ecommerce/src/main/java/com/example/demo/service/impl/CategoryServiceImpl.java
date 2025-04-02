package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;
    
    @Override
    public Category addCategory(CategoryDto categoryDto) {
        Category category = new Category();

        BeanUtils.copyProperties(categoryDto, category);

        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryDto categoryDto) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        BeanUtils.copyProperties(categoryDto, category);

        Set<Product> products = new HashSet<>();

        for(Long productId: categoryDto.getProductIds()){
            Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
            products.add(product);
        }

        category.setProducts(products);
        return categoryRepo.save(category);
    }

    @Override
    public void softDeleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
        category.setDeleted(true);
        categoryRepo.save(category);
    }
    
    
}
