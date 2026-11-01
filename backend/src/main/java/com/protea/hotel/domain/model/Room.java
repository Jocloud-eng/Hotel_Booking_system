package com.protea.hotel.domain.model;

/**
 * Room entity. Holds availability and pricing invariants.
 */
public class Room {
    private final Long id;
    private final String roomNumber;
    private RoomType type;
    private double nightlyRate;
    private boolean available;

    public Room(Long id, String roomNumber, RoomType type, double nightlyRate) {
        if (roomNumber == null || roomNumber.isBlank()) throw new IllegalArgumentException("Room number is required");
        if (type == null) throw new IllegalArgumentException("Room type is required");
        if (nightlyRate <= 0) throw new IllegalArgumentException("Nightly rate must be positive");
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.nightlyRate = nightlyRate;
        this.available = true;
    }

    public Long getId() { return id; }
    public String getRoomNumber() { return roomNumber; }
    public RoomType getType() { return type; }
    public double getNightlyRate() { return nightlyRate; }
    public boolean isAvailable() { return available; }

    public void markBooked() { this.available = false; }
    public void markAvailable() { this.available = true; }
    public void updateRate(double newRate) {
        if (newRate <= 0) throw new IllegalArgumentException("Nightly rate must be positive");
        this.nightlyRate = newRate;
    }
}