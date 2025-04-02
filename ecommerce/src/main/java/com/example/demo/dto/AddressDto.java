package com.example.demo.dto;

import java.util.Set;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "Building name is required")
    private String buildingName;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Country is required")
    private String country;
    @NotBlank(message = "Pin code is required")
    private String pincode;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Street is required")
    private String street;

    private Set<Long> userIds;
}
