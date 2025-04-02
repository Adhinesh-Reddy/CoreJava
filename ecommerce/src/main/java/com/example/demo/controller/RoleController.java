package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoleDto;
import com.example.demo.entity.Role;
import com.example.demo.repo.RoleRepo;
import com.example.demo.service.impl.RoleServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto){
        Role addRole = roleServiceImpl.addRole(roleDto);

        if(addRole!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addRole);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role Not Added");   
    }

    @PutMapping("/update/{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable Long roleId, @RequestBody RoleDto roleDto){
        Role updateRole = roleServiceImpl.updateRole(roleDto, roleId);

        if(updateRole!=null)
            return ResponseEntity.status(HttpStatus.OK).body("Role updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role not updated");
        
    }

    @DeleteMapping("/delete/{roleId}")
    public ResponseEntity<?> softDeleteRole(@PathVariable Long roleId){
        roleServiceImpl.softDeleteRole(roleId);

        return ResponseEntity.status(HttpStatus.OK).body("Role deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRoles(){
        return ResponseEntity.status(HttpStatus.OK).body(roleRepo.findAll());
    }
    @GetMapping("/{roleId}")
    public ResponseEntity<?> fetchSpecificRoleId(@PathVariable Long roleId){
        return ResponseEntity.status(HttpStatus.OK).body(roleRepo.findById(roleId));
    }
}
