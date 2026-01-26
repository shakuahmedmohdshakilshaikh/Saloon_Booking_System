package com.shaku.salon_booking.Service;




import com.shaku.salon_booking.Model.Booking;
import com.shaku.salon_booking.Model.Payment;
import com.shaku.salon_booking.Repository.BookingRepository;
import com.shaku.salon_booking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Payment makePayment(Payment payment) {

        // Validate booking exists
        Booking booking = bookingRepository.findById(
                payment.getBooking().getId()
        ).orElseThrow(() -> new RuntimeException("Booking not found"));

        payment.setAmount(booking.getService().getPrice());
        payment.setPaymentStatus("PAID");

        return paymentRepository.save(payment);
    }
}
