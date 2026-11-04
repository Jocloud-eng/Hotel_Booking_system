package com.protea.hotel.domain.repository;

import com.protea.hotel.domain.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    List<Room> findAll();
    Optional<Room> findById(Long id);
    Optional<Room> findByRoomNumber(String roomNumber);
    List<Room> findAvailable();
    Room save(Room room);
    void deleteById(Long id);
}