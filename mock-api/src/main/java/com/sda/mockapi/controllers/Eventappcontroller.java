package com.sda.mockapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sda.mockapi.models.Eventappmodel;

@RestController
@RequestMapping("/events")
public class Eventappcontroller {
    
    // List of events
    @GetMapping
    public List<Eventappmodel> getEvents(@RequestParam(required = false) String category) {
        List<Eventappmodel> events = new ArrayList<>();
        
        // Adding some sample events
        events.add(new Eventappmodel(1, "Rock Concert", "Music", "Cairo", "2024-12-25", 50));
        events.add(new Eventappmodel(2, "Art Festival", "Cultural", "Giza", "2024-12-26", 30));
        events.add(new Eventappmodel(3, "Outdoor Adventure", "Outdoor", "Octaber", "2024-12-27", 100));
        events.add(new Eventappmodel(4, "Comedy Show", "Comedy", "Alexandria", "2024-12-28", 40));
        events.add(new Eventappmodel(5, "Cairo Jazz Night", "Music", "Cairo", "2024-12-29", 60));
        events.add(new Eventappmodel(6, "Giza Historical Tour", "Cultural", "Giza", "2024-12-30", 120));
        events.add(new Eventappmodel(7, "Sharm El Sheikh Beach Party", "Outdoor", "Sharm El Sheikh", "2024-12-31", 80));
        events.add(new Eventappmodel(8, "Luxor Light Festival", "Cultural", "Luxor", "2025-01-01", 70));

        // Filter events by category if 'category' is passed as a query parameter
        if (category != null) {
            events.removeIf(event -> !event.getCategory().equalsIgnoreCase(category));
        }

        return events;
    }
}
