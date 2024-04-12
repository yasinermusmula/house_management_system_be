package com.example.demo.service;

import com.example.demo.dto.HouseListingDto;
import com.example.demo.entity.HouseListing;
import com.example.demo.entity.User;
import com.example.demo.repository.HouseListingRepository;
import com.example.demo.util.HouseListingConvertion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class HouseListingServiceImpl implements HouseListingService{

    private HouseListingRepository houseListingRepository;
    private UserService userService;

    @Autowired
    public HouseListingServiceImpl(HouseListingRepository houseListingRepository, UserService userService) {
        this.houseListingRepository = houseListingRepository;
        this.userService = userService;
    }

    @Override
    public HouseListingDto save(HouseListing houseListing, Long userId) {
        User user = userService.findByOriginal(userId);
        if (user != null){
            HouseListing newHouseListing = new HouseListing();
            newHouseListing.setTitle(houseListing.getTitle());
            newHouseListing.setDescription(houseListing.getDescription());
            newHouseListing.setPhotoUrls(houseListing.getPhotoUrls());
            newHouseListing.setProperty(houseListing.getProperty());
            newHouseListing.setUser(user);
            return HouseListingConvertion.convertHouseListing(newHouseListing);
        }
        //TODO Make Exceptions here
        return null;
    }

    @Override
    public List<HouseListingDto> findAll() {
        List<HouseListing> houseListings = houseListingRepository.findAll();
        return HouseListingConvertion.convertList(houseListings);
    }

    @Override
    public List<HouseListingDto> findByUser(Long userId) {
        List<HouseListing> houseListings = houseListingRepository.findHouseListingByUserId(userId);
        return HouseListingConvertion.convertList(houseListings);
    }

    @Override
    public HouseListingDto delete(Long id) {
        HouseListing houseListing = findByOriginal(id);
        houseListingRepository.delete(houseListing);
        return HouseListingConvertion.convertHouseListing(houseListing);
    }

    @Override
    public HouseListing findByOriginal(Long id) {
        return houseListingRepository.findById(id).orElse(null);
    }
}
