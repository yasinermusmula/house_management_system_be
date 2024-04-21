package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserDto save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/")
    public List<UserDto> findAll(){
        return userService.findAllUser();
    }

    @GetMapping("/verify")
    public UserResponseDto getUser(@RequestParam String email){
        return userService.findUserEmail(email);
    }
}
