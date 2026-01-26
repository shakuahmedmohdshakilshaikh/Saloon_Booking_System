package com.shaku.salon_booking.Service;

import com.shaku.salon_booking.Model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getUserBookings(Long userId);
    List<Booking> getAllBookings();

    void deleteService(Long id);
}
