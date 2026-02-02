package com.shaku.salon_booking.Service;


import com.shaku.salon_booking.Model.Payment;

import java.util.List;

public interface PaymentService {

    Payment makePayment(Payment payment);

    List<Payment> getAllPayment();
}

