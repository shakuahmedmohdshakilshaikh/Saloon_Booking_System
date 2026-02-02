package com.shaku.salon_booking.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;
    private String timeSlot;

    private String status;

    @ManyToOne
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JsonManagedReference
    private ServiceEntity service;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    private Salon salon;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Payment> payments;




    public Booking(Long id, LocalDate bookingDate, String timeSlot, String status, User user, ServiceEntity service, Salon salon, List<Payment> payments) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.timeSlot = timeSlot;
        this.status = status;
        this.user = user;
        this.service = service;
        this.salon = salon;
        this.payments = payments;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
