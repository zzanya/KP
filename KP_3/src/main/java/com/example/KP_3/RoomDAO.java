package com.example.KP_3;

import java.util.List;

public interface RoomDAO {
    List<Room> getAllRooms();

    Room getRoomById(Long id);

    void addRoom(Room room);

    void updateRoom(Room room);

    void deleteRoom(Long id);
}