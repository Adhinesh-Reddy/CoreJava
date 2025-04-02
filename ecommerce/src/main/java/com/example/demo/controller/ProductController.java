package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.impl.ProductServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto){
        Product addProduct = productServiceImpl.addProduct(productDto);

        if(addProduct != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addProduct);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Not Added");
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductDto productDto){
        Product updateProduct = productServiceImpl.updateProduct(productId, productDto);

        if(updateProduct != null)
            return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not updated");
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> softDeleteProduct(@PathVariable Long productId){
        productServiceImpl.softDeleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> fetchSpecificProductId(@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.findById(productId));
    }
}
