package com.sda.mockapi.controllers;

import com.sda.mockapi.models.HotelBook;  // We will create this model shortly
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    // Simulate getting hotel data with fake data
    @GetMapping("/search")
    public List<HotelBook> getHotels() {
        // Creating fake hotel data
        HotelBook hotel1 = new HotelBook(1, "Luxury Hotel", "Paris", 150.0);
        HotelBook hotel2 = new HotelBook(2, "Beach Resort", "Maldives", 250.0);

        return Arrays.asList(hotel1, hotel2);
    }
}
