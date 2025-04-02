package com.example.demo.dto;


import java.util.Set;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Username is required")
    private String username;

    private Set<Long> addressIds;

    private Set<Long> roleIds;

    private Set<Long> productIds;

    private Set<Long> cartIds;
}