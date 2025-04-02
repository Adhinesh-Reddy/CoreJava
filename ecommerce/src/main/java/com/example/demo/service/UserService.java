package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.dto.UserDto;

public interface UserService {
    public User registerUser(UserDto userDto);
    public User updateUser(Long userId, UserDto userDto);
    public void softDeleteUser(Long userId);
}
