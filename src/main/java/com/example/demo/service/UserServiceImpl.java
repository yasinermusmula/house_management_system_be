package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.UserDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(User user) {
        //TODO Make validation here and write exceptions
        userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return UserDtoConvertion.convertUser(user);
        }
        //TODO Make validation here and write exceptions
        return null;
    }

    @Override
    public UserDto delete(Long id) {
        UserDto userDto = findById(id);
        if (userDto != null){
            userRepository.deleteById(id);
            return userDto;
        }
        //TODO Make validation here and write exceptions
        return null;
    }

    @Override
    public User findByOriginal(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> userList = userRepository.findAll();
        return UserDtoConvertion.convertList(userList);
    }

    @Override
    public List<UserDto> findUsersEmail(String email) {
        List<User> userList = userRepository.findUserByEmail(email);
        return UserDtoConvertion.convertList(userList);
    }
}
