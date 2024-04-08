package com.example.demo.service;

import com.example.demo.dto.HouseListingDto;
import com.example.demo.entity.HouseListing;

import java.util.List;

public interface HouseListingService {
    HouseListingDto save (HouseListing houseListing, Long userId);

    List<HouseListingDto> findAll();

    List<HouseListingDto> findByUser(Long userId);

    HouseListingDto delete(Long userId);

    HouseListing findByOriginal(Long id);
}
