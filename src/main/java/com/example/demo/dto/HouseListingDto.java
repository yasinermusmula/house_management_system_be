package com.example.demo.dto;
import com.example.demo.entity.Houses;
import com.example.demo.entity.Review;
import com.example.demo.entity.User;

import java.util.List;

public record HouseListingDto(String title,
                              String description,
                              Houses property,
                              Long userId) {
}
