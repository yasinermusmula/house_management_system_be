package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    UserDto save(User user);

    UserDto findById(Long id);

    UserDto delete(Long id);

    List<UserDto> findAllUser();

    List<UserDto> findUsersEmail(String email);
}
