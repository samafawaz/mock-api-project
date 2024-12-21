package com.sda.mockapi.controllers;

import org.springframework.web.bind.annotation.*;

import com.sda.mockapi.models.Hotel;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    // Simulate getting hotel data with fake data
    @GetMapping("/search")
    public List<Hotel> getHotels() {
        // Creating fake hotel data
        Hotel hotel1 = new Hotel(1, "Luxury Hotel", "Paris", 150.0);
        Hotel hotel2 = new Hotel(2, "Beach Resort", "Maldives", 250.0);

        return Arrays.asList(hotel1, hotel2);
    }
}
