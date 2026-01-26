package com.shaku.salon_booking.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequest {

    @NotNull(message = "Booking date is required")
    @FutureOrPresent(message = "Booking date cannot be in the past")
    public LocalDate bookingDate;

    @NotNull(message = "Service ID is required")
    public Long serviceId;

    @NotNull(message = "Salon ID is required")
    public Long salonId;
}
