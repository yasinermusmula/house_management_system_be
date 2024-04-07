package com.example.demo.util;

import com.example.demo.dto.HouseListingDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.HouseListing;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class  HouseListingConvertion {

    public static List<HouseListingDto> convertList(List<HouseListing> houseListings){
        List<HouseListingDto> houseListingDtos = new ArrayList<>();
        houseListings.stream().forEach(houseListing ->
                houseListingDtos.add(new HouseListingDto(houseListing.getTitle(),houseListing.getDescription(),houseListing.getPhotoUrls(),houseListing.getProperty(),houseListing.getUser().getId(),houseListing.getReviews())));
        return houseListingDtos;
    }

    public static UserDto convertUser(User user){
        return new UserDto(user.getName(), user.getSirName(), user.getEmail(), user.getListings(),user.getReservations());
    }
}
