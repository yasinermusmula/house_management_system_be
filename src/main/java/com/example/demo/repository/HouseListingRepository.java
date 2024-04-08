package com.example.demo.repository;

import com.example.demo.entity.HouseListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseListingRepository extends JpaRepository<HouseListing,Long> {

    @Query("SELECT u FROM HouseListing u WHERE u.user.id = :userId")
    List<HouseListing> findHouseListingByUserId(Long userId);
}
