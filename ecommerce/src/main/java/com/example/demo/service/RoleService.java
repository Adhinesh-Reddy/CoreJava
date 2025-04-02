package com.example.demo.service;

import com.example.demo.dto.RoleDto;
import com.example.demo.entity.Role;

public interface RoleService {
    public Role addRole(RoleDto roleDto);
    public Role updateRole(RoleDto roleDto, Long RoleId);
    public void softDeleteRole(Long roleId);
}
