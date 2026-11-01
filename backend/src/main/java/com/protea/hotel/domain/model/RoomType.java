package com.protea.hotel.domain.model;

public enum RoomType {
    STANDARD("Standard"),
    DELUXE("Deluxe"),
    EXECUTIVE_SUITE("Executive Suite"),
    LAKEFRONT_DELUXE("Lakefront Deluxe");

    private final String displayName;

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}