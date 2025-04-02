package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.RoleName;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    // @NotBlank(message = "Role name is required")
    private RoleName roleName;

    private Set<Long> userIds;
}
