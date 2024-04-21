package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    UserDto save(User user);

    UserDto findById(Long id);

    UserDto delete(Long id);

    User findByOriginal(Long id);

    List<UserDto> findAllUser();

    UserResponseDto findUserEmail(String email);
}
