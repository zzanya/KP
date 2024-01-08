package com.example.KP_3;

import java.util.List;

public interface BookingDAO {
    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Long id);
}
