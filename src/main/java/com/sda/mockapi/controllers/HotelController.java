package com.sda.mockapi.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.mockapi.models.Hotel;
import com.sda.mockapi.models.Room;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private List<Hotel> hotels = initializeHotels();

    @GetMapping("/search")
    public List<Hotel> getHotels() {
        return hotels;
    }

    // hotel data 
    public List<Hotel> initializeHotels() {

        Hotel hotel1 = new Hotel(
            1,
            "Ritz-Carlton Nile",
            "Cairo",
            createRooms(1, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE), 3, 2, 0),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE),
            300.0
        );

        Hotel hotel2 = new Hotel(
            2,
            "Hilton Alexandria Green Plaza",
            "Alexandria",
            createRooms(2, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY), 2, 3, 2),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY),
            150.0
        );

        Hotel hotel3 = new Hotel(
            3,
            "Cairo Pyramids Hotel",
            "Cairo",
            createRooms(3, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.FAMILY), 4, 0, 1),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.FAMILY),
            100.0
        );

        Hotel hotel4 = new Hotel(
            4,
            "Steigenberger Cecil Hotel",
            "Alexandria",
            createRooms(4, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE), 5, 2, 0),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE),
            120.0
        );

        Hotel hotel5 = new Hotel(
            5,
            "Hurghada Marriott Beach Resort",
            "Hurghada",
            createRooms(5, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY), 2, 4, 3),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY),
            200.0
        );

        Hotel hotel6 = new Hotel(
            6,
            "Jaz Fanara Resort",
            "Sharm El-Sheikh",
            createRooms(6, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY), 1, 1, 1),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY),
            180.0
        );

        Hotel hotel7 = new Hotel(
            7,
            "Winter Palace Luxor",
            "Luxor",
            createRooms(7, Arrays.asList(Room.RoomType.SINGLE), 3, 0, 0),
            Arrays.asList(Room.RoomType.SINGLE),
            140.0
        );

        Hotel hotel8 = new Hotel(
            8,
            "Sofitel Legend Old Cataract",
            "Aswan",
            createRooms(8, Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY), 2, 3, 1),
            Arrays.asList(Room.RoomType.SINGLE, Room.RoomType.DOUBLE, Room.RoomType.FAMILY),
            220.0
        );

        // Combine all hotels into a single list and return
        return Arrays.asList(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8);
    }

    private static List<Room> createRooms(int hotelId, List<Room.RoomType> allowedTypes, int single, int doubleRoom, int family) {
        List<Room> rooms = new ArrayList<>();
        int roomId = 0;
        if (allowedTypes.contains(Room.RoomType.SINGLE)) {
            for (int i = 0; i < single; i++) {
                rooms.add(new Room(hotelId*100 + roomId++, Room.RoomType.SINGLE, false));
            }
        }
        if (allowedTypes.contains(Room.RoomType.DOUBLE)) {
            for (int i = 0; i < doubleRoom; i++) {
                rooms.add(new Room(hotelId*100 + roomId++, Room.RoomType.DOUBLE, false));
            }
        }
        if (allowedTypes.contains(Room.RoomType.FAMILY)) {
            for (int i = 0; i < family; i++) {
                rooms.add(new Room(hotelId*100 + roomId++, Room.RoomType.FAMILY, false));
            }
        }
        return rooms;
    }

    @PutMapping("/rooms/{roomId}/reserve")
    public ResponseEntity<String> reserveRoom(@PathVariable int roomId) {
        for (Hotel hotel : hotels) {
            for (Room room : hotel.getRooms()) {
                if (room.getId() == roomId) {
                    if (!room.getReserved()) {
                        room.setReserved(true);
                        return ResponseEntity.ok("Room reserved successfully.");
                    } else {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("Room is already reserved.");
                    }
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found.");
    }
}
