package com.example.competa.service;

import com.example.competa.dto.UserDto;
import com.example.competa.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
