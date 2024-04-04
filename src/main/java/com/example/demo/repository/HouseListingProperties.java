package com.example.demo.repository;

import com.example.demo.entity.HouseListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseListingProperties extends JpaRepository<HouseListing,Long> {
}
