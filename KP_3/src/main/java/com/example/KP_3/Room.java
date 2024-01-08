package com.example.KP_3;

import org.springframework.web.multipart.MultipartFile;

public class Room {
    private Long id;
    private String roomNumber;
    private String type;
    private double price;
    private MultipartFile photo;

    // геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
