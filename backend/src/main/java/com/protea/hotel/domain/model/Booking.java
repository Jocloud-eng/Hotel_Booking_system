package com.protea.hotel.domain.model;

import java.time.LocalDate;

/**
 * Booking aggregate root. Enforces booking invariants (dates, guests).
 */
public class Booking {
    private final Long id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private int guests;
    private BookingStatus status;
    private double totalAmount;

    public Booking(Long id, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut, int guests) {
        if (guest == null) throw new IllegalArgumentException("Guest is required");
        if (room == null) throw new IllegalArgumentException("Room is required");
        if (checkIn == null || checkOut == null) throw new IllegalArgumentException("Dates are required");
        if (!checkOut.isAfter(checkIn)) throw new IllegalArgumentException("Check-out must be after check-in");
        if (guests < 1) throw new IllegalArgumentException("At least one guest required");
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.status = BookingStatus.PENDING;
        this.totalAmount = computeTotal();
    }

    private double computeTotal() {
        long nights = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
        return room.getNightlyRate() * nights;
    }

    public Long getId() { return id; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public int getGuests() { return guests; }
    public BookingStatus getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }

    public void confirm() {
        if (status != BookingStatus.PENDING) throw new IllegalStateException("Only pending bookings can be confirmed");
        status = BookingStatus.CONFIRMED;
        room.markBooked();
    }

    public void cancel() {
        if (status == BookingStatus.COMPLETED) throw new IllegalStateException("Completed bookings cannot be cancelled");
        status = BookingStatus.CANCELLED;
        room.markAvailable();
    }
}