package com.example.demo.controller;

import com.example.demo.dto.HouseListingDto;
import com.example.demo.entity.HouseListing;
import com.example.demo.service.HouseListingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@NoArgsConstructor
@RestController
@RequestMapping("/housing")
public class HouseListingController {


    private HouseListingService houseListingService;

    @Autowired
    public HouseListingController(HouseListingService houseListingService) {
        this.houseListingService = houseListingService;
    }

    @PostMapping("/{userId}")
    public HouseListingDto save(@RequestBody HouseListing houseListing,
                                @PathVariable Long userId){
        return houseListingService.save(houseListing,userId);
    }

    @GetMapping("/")
    public List<HouseListingDto> findAll(){
        return houseListingService.findAll();
    }

    @GetMapping("/{userId}")
    public List<HouseListingDto> findByUser(@PathVariable Long userId){
        return houseListingService.findByUser(userId);
    }

    @DeleteMapping("/{id}")
    public HouseListingDto delete(@PathVariable Long id){
        return houseListingService.delete(id);
    }
}
