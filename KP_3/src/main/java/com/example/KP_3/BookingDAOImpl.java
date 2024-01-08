package com.example.KP_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM Bookings";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Booking.class));
    }

    @Override
    public Booking getBookingById(Long id) {
        String sql = "SELECT * FROM Bookings WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Booking.class));
    }

    @Override
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO Bookings (roomId, userId, checkInDate, checkOutDate) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                booking.getRoom().getId(),
                booking.getUser().getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate());
    }

    @Override
    public void updateBooking(Booking booking) {
        String sql = "UPDATE Bookings SET roomId=?, userId=?, checkInDate=?, checkOutDate=? WHERE id=?";
        jdbcTemplate.update(sql,
                booking.getRoom().getId(),
                booking.getUser().getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getId());
    }

    @Override
    public void deleteBooking(Long id) {
        String sql = "DELETE FROM Bookings WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
