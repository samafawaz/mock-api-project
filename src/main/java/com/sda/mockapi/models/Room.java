package com.sda.mockapi.models;

public class Room {
    public enum RoomType {
       
        SINGLE, DOUBLE, FAMILY
    }

    private int id;
    private boolean reserved;
    private RoomType type;

    public Room(int id, RoomType type, boolean reserved) {
        this.type = type;
        this.reserved = reserved;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public RoomType getType() {
        return type;
    }
}
