package com.sda.mockapi.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.mockapi.models.Hotel;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    // Simulate getting hotel data with fake data
    @GetMapping("/search")
    public List<Hotel> getHotels() {

        Hotel hotel1 = new Hotel(3, "Cairo Pyramids Hotel", "Cairo", 100.0);
        Hotel hotel2 = new Hotel(4, "Steigenberger Cecil Hotel", "Alexandria", 120.0);
        Hotel hotel3 = new Hotel(5, "Hurghada Marriott Beach Resort", "Hurghada", 200.0);
        Hotel hotel4 = new Hotel(6, "Jaz Fanara Resort", "Sharm El-Sheikh", 180.0);
        Hotel hotel5 = new Hotel(7, "Winter Palace Luxor", "Luxor", 140.0);
        Hotel hotel6 = new Hotel(8, "Sofitel Legend Old Cataract", "Aswan", 220.0);

        // Combine all hotels into a single list and return
        return Arrays.asList(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6);
    }
}
