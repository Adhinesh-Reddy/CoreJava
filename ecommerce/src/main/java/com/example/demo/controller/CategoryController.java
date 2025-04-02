package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.impl.CategoryServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category addCategory = categoryServiceImpl.addCategory(categoryDto);

        if (addCategory != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addCategory);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category Not Added");
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
        Category updateCategory = categoryServiceImpl.updateCategory(categoryId, categoryDto);

        if (updateCategory != null)
            return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not updated");
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> softDeleteCategory(@PathVariable Long categoryId) {
        categoryServiceImpl.softDeleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.findAll());
    }

    @GetMapping("/get/{categoryId}")
    public ResponseEntity<?> fetchSpecificCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.findById(categoryId).orElse(null));
    }
}
