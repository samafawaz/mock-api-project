package com.sda.mockapi.models;

public class Room {
    public enum RoomType {
       
        SINGLE, DOUBLE, FAMILY
    }

    private boolean reserved;
    private RoomType type;

    public Room(RoomType type, boolean reserved) {
        this.type = type;
        this.reserved = reserved;
    }

    public boolean getReserved() {
        return reserved;
    }

    public RoomType getType() {
        return type;
    }
}
