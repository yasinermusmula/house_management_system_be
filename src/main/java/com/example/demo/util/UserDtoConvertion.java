package com.example.demo.util;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {

    public static List<UserDto> convertList(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        users.stream().forEach(user ->
                userDtos.add(new UserDto(user.getName(), user.getSirName(),
                        user.getEmail(),user.getListings(),user.getReservations())));
        return userDtos;
    }

    public static UserDto convertUser(User user){
        return new UserDto(user.getName(), user.getSirName(), user.getEmail(), user.getListings(),user.getReservations());
    }

}
