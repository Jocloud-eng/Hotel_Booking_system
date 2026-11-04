package com.protea.hotel.domain.repository;

import com.protea.hotel.domain.model.Guest;

import java.util.Optional;

public interface GuestRepository {
    Optional<Guest> findById(Long id);
    Optional<Guest> findByEmail(String email);
    Guest save(Guest guest);
}