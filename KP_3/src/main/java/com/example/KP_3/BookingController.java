package com.example.KP_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookingDAO bookingDAO;

    @GetMapping("/rooms")
    public String showRooms(Model model) {
        List<Room> rooms = roomDAO.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute Room room) {
        roomDAO.addRoom(room);
        return "redirect:/booking/rooms";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userDAO.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userDAO.addUser(user);
        return "redirect:/booking/users";
    }

    @GetMapping("/bookings")
    public String showBookings(Model model) {
        List<Booking> bookings = bookingDAO.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

    @PostMapping("/addBooking")
    public String addBooking(@ModelAttribute Booking booking) {
        bookingDAO.addBooking(booking);
        return "redirect:/booking/bookings";
    }

    // Другие методы для обновления, удаления, отображения форм и т.д.
}

