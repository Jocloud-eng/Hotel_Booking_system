package com.protea.hotel.domain.model;

/**
 * Domain entity representing a hotel property.
 * Rich domain model: invariants are enforced inside the entity.
 */
public class Hotel {
    private final Long id;
    private String name;
    private String location;
    private int totalRooms;

    public Hotel(Long id, String name, String location, int totalRooms) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Hotel name is required");
        if (totalRooms < 0) throw new IllegalArgumentException("Total rooms cannot be negative");
        this.id = id;
        this.name = name;
        this.location = location;
        this.totalRooms = totalRooms;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getTotalRooms() { return totalRooms; }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) throw new IllegalArgumentException("Hotel name is required");
        this.name = newName;
    }
}