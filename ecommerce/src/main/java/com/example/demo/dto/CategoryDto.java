package com.example.demo.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotBlank(message = "Category name is required")
    private String categoryName;

    Set<Long> productIds;
}
