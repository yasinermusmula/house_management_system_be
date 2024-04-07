package com.example.demo.dto;

import com.example.demo.entity.HouseListing;
import com.example.demo.entity.Reservation;

import java.util.List;

public record   UserDto(String name, String sirName, String email, List<HouseListing> listings, List<Reservation> reservations) {
}
