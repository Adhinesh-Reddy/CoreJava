package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.repo.UserRepo;
import com.example.demo.entity.User;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl UserServiceImpl;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<?> registeruser(@Valid @RequestBody UserDto userDto){
        User registerUser = UserServiceImpl.registerUser(userDto);
        if(registerUser!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not Registered");
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto){
        User updateUser = UserServiceImpl.updateUser(userId, userDto);
        if(updateUser!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updateUser);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not updated");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> softDeleteUser(@PathVariable Long userId){
        UserServiceImpl.softDeleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        // return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAllActiveUsers());
        return userRepo.findAllActiveUsers();
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<?> fetchSpecificUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepo.findByUserIdAndIsDeletedFalse(userId));
    }
    
}


// {
//     "email": "adhinesh6@outlook.com",
//     "password": "TSKTRbe6101@@",
//     "username": "adhinesh6",
//     "addressIds": [1],
// }