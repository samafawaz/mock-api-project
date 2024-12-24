package com.sda.mockapi.controllers;

import com.sda.mockapi.models.Event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    private List<Event> events = initializeEvents();

    @GetMapping("/search")
    public List<Event> getHotels() {
        return events;
    }

    public List<Event> initializeEvents() {
        List<Event> e = new ArrayList<>();
        
        // Adding some sample events
        e.add(new Event(1, "Rock Concert", "Music", "Cairo", "2024-12-25", 50, 100));
        e.add(new Event(2, "Art Festival", "Cultural", "Giza", "2024-12-26", 30, 75));
        e.add(new Event(3, "Outdoor Adventure", "Outdoor", "Octaber", "2024-12-27", 100, 150));
        e.add(new Event(4, "Comedy Show", "Comedy", "Alexandria", "2024-12-28", 40, 80));
        e.add(new Event(5, "Cairo Jazz Night", "Music", "Cairo", "2024-12-29", 60, 200));
        e.add(new Event(6, "Giza Historical Tour", "Cultural", "Giza", "2024-12-30", 120, 200));
        e.add(new Event(7, "Sharm El Sheikh Beach Party", "Outdoor", "Sharm El Sheikh", "2024-12-31", 80, 120));
        e.add(new Event(8, "Luxor Light Festival", "Cultural", "Luxor", "2025-01-01", 70, 500));

        return e;
    }

    @PutMapping("/{eventId}/reserve")
    public ResponseEntity<String> reserveRoom(@PathVariable int eventId) {
        for (Event event: events) {
            if (event.getId() == eventId) {
                if (event.getAvailableTickets() > 0) {
                    event.setAvailableTickets(event.getAvailableTickets() - 1);
                    return ResponseEntity.ok("Ticket reserved successfully.");
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Event is fully booked.");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
    }
}