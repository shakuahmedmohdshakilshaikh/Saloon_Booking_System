package com.shaku.salon_booking.Model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int durationMinutes;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServiceImage> images;


    @ManyToOne
    @JoinColumn(name = "salon_id")
    @JsonManagedReference
    private Salon salon;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookings;

    public ServiceEntity(Long id, String name, String description, double price, int durationMinutes, List<ServiceImage> images, Salon salon, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.images = images;
        this.salon = salon;
        this.bookings = bookings;
    }

    public ServiceEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public List<ServiceImage> getImages() {
        return images;
    }

    public void setImages(List<ServiceImage> images) {
        this.images = images;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", durationMinutes=" + durationMinutes +
                ", images=" + images +
                ", salon=" + salon +
                ", bookings=" + bookings +
                '}';
    }
}

