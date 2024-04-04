package com.example.demo.dto;

public record ReservationDto(String startDate,String endDate,Double totalPrice, Long userId, Long houseListingId) {
}
