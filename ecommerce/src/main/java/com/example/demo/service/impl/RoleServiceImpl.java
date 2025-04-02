package com.example.demo.service.impl;

import com.example.demo.dto.RoleDto;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import com.example.demo.repo.RoleRepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role addRole(RoleDto roleDto) {
        Role role = new Role();

        BeanUtils.copyProperties(roleDto, role);

        return roleRepo.save(role);
    }

    @Override
    public Role updateRole(RoleDto roleDto, Long RoleId) {
        Role role = roleRepo.findById(RoleId).orElseThrow(()->new RuntimeException("Role not found with id: "+ RoleId));

        BeanUtils.copyProperties(roleDto, role);

        return roleRepo.save(role);
    }

    @Override
    public void softDeleteRole(Long roleId) {
        Role role = roleRepo.findById(roleId).orElseThrow(()->new RuntimeException("Role not found with id: "+ roleId));

        role.setDeleted(true);

        roleRepo.save(role);
    }
    
}
