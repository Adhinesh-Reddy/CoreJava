package com.example.demo.dto;

import java.util.Set;
import jakarta.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    @NotNull(message = "Total price is required")
    private double totalPrice;

    Set<Long> cartItemIds;
}
