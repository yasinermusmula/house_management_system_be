package com.example.demo.controller;

import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin("*")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUserDto registerUSerDto){
        return authenticationService.register(registerUSerDto.email(), registerUSerDto.name(), registerUSerDto.password()
                ,registerUSerDto.role(), registerUSerDto.sirname());
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody LoginUserDto loginUserDto) {
        return authenticationService.login(loginUserDto);
    }
}
