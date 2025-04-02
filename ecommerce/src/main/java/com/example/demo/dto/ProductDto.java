package com.example.demo.dto;

import java.util.Set;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotBlank(message = "Description name is required")
    private String description;
    @NotNull(message = "Discount is required")
    private Double discount;
    @NotBlank(message = "Image is required")
    private String image;
    @NotNull(message = "Price is required")
    private Double price;
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotNull(message = "Quantity is required")
    private int quantity;
    @NotNull(message = "Special price is required")
    private Double specialPrice;
    @NotNull(message = "Seller Id is required")
    private int sellerId;

    private Set<Long> cartItemIds;
    private Set<Long> orderItemIds;
    
}
