package com.example.KP_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM Rooms";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Room.class));
    }

    @Override
    public Room getRoomById(Long id) {
        String sql = "SELECT * FROM Rooms WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Room.class));
    }

    @Override
    public void addRoom(Room room) {
        String sql = "INSERT INTO Rooms (roomNumber, type, price, photo) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                room.getRoomNumber(),
                room.getType(),
                room.getPrice(),
                room.getPhoto());
    }

    @Override
    public void updateRoom(Room room) {
        String sql = "UPDATE Rooms SET roomNumber=?, type=?, price=?, photo=? WHERE id=?";
        jdbcTemplate.update(sql,
                room.getRoomNumber(),
                room.getType(),
                room.getPrice(),
                room.getPhoto(),
                room.getId());
    }

    @Override
    public void deleteRoom(Long id) {
        String sql = "DELETE FROM Rooms WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

