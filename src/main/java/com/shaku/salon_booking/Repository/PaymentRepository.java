package com.shaku.salon_booking.Repository;


import com.shaku.salon_booking.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

