package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    @NotNull(message = "Discount is required")
    private double discount;
    @NotNull(message = "Product price is required")
    private double productPrice;
    @NotNull(message = "Quantity is required")
    private int quantity;


}
