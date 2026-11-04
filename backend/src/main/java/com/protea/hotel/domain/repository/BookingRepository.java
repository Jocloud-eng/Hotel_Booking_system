package com.protea.hotel.domain.repository;

import com.protea.hotel.domain.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);
    List<Booking> findAll();
    List<Booking> findByGuest(Long guestId);
}