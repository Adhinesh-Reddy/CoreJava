package com.example.demo.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsDto {
    @NotBlank(message = "Payment method is required")
    private String paymentMethod; // e.g. "Credit Card", "PayPal", etc.

    Set<Long> orderIds;
}
