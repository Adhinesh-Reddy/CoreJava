package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;

public interface CategoryService {
    public Category addCategory(CategoryDto categoryDto);
    public Category updateCategory(Long categoryId, CategoryDto categoryDto);
    public void softDeleteCategory(Long categoryId);
}
