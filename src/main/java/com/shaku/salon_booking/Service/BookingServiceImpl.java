package com.shaku.salon_booking.Service;

import com.shaku.salon_booking.Model.Booking;
import com.shaku.salon_booking.Repository.BookingRepository;
import com.shaku.salon_booking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteService(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Service not found");
        }
        bookingRepository.deleteById(id);
    }
}

