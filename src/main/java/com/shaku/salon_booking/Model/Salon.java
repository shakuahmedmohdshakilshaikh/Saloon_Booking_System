package com.shaku.salon_booking.Model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;
    private String openingTime;
    private String closingTime;

    private String status;

//    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<Booking> bookings;

    public Salon(Long id, String name, String address, String phone, String openingTime, String closingTime, String status, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
//        this.bookings = bookings;
    }

    public Salon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
}
