package com.example.demo.service;

import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.GlobalExceptions;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String email,String name,String password,String role,String sirname){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        if (role.equals("ADMIN")){
            userRole = roleRepository.findByAuthority("ADMIN").get();
        }

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();
        user.setName(name);
        user.setSirname(sirname);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public UserResponseDto login(LoginUserDto loginUserDto){
        Optional<User> userOptional = userRepository.findUserByEmail(loginUserDto.email());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (passwordEncoder.matches(loginUserDto.password(), user.getPassword())){
                return new UserResponseDto(user.getName());
            }
        }
        throw new GlobalExceptions("User is not valid", HttpStatus.BAD_REQUEST);
    }
}
