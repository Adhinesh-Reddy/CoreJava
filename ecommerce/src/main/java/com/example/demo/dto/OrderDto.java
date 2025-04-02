package com.example.demo.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @NotBlank(message = "Order description is required")
    private String email;
    @NotBlank(message = "Order date is required")
    private String orderDate;
    @NotBlank(message = "Order status is required")
    private String orderStatus;
    @NotNull(message = "Total amount is required") // Use @NotNull to ensure the value is not null
    private double totalAmount;

    private Set<Long> orderItemIds;
}
