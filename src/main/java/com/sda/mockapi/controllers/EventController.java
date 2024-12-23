package com.sda.mockapi.controllers;

import com.sda.mockapi.models.Event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    // List of events
    @GetMapping("/search")
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        
        // Adding some sample events
        events.add(new Event(1, "Rock Concert", "Music", "Cairo", "2024-12-25", 50, 100));
        events.add(new Event(2, "Art Festival", "Cultural", "Giza", "2024-12-26", 30, 75));
        events.add(new Event(3, "Outdoor Adventure", "Outdoor", "Octaber", "2024-12-27", 100, 150));
        events.add(new Event(4, "Comedy Show", "Comedy", "Alexandria", "2024-12-28", 40, 80));
        events.add(new Event(5, "Cairo Jazz Night", "Music", "Cairo", "2024-12-29", 60, 200));
        events.add(new Event(6, "Giza Historical Tour", "Cultural", "Giza", "2024-12-30", 120, 200));
        events.add(new Event(7, "Sharm El Sheikh Beach Party", "Outdoor", "Sharm El Sheikh", "2024-12-31", 80, 120));
        events.add(new Event(8, "Luxor Light Festival", "Cultural", "Luxor", "2025-01-01", 70, 500));

        return events;
    }
}