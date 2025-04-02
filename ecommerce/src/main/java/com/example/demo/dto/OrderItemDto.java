package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    
    @NotNull
    private double discount;

    @NotNull
    private double orderedProductPrice;

    @NotNull
    private int quantity;

    
}
