package com.sda.mockapi.models;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private List<Room> rooms;
    private List<Room.RoomType> availableRoomTypes;  
    private double price;

    // Constructor
    public Hotel(int id, String name, String location, List<Room> rooms, List<Room.RoomType> availableRoomTypes, double price) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.availableRoomTypes = availableRoomTypes;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room.RoomType> getAvailableRoomTypes() {
        return availableRoomTypes;
    }

    public void setAvailableRoomTypes(List<Room.RoomType> availableRoomTypes) {
        this.availableRoomTypes = availableRoomTypes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
