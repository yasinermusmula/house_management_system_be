package com.example.demo.controller;

import com.example.demo.dto.RegisterUSerDto;
import com.example.demo.entity.User;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUSerDto registerUSerDto){
        return authenticationService.register(registerUSerDto.email(), registerUSerDto.name(), registerUSerDto.password()
                ,registerUSerDto.role(), registerUSerDto.sirname());
    }
}
