package com.shaku.salon_booking.Controller;

import com.shaku.salon_booking.Model.Payment;
import com.shaku.salon_booking.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getPayment(){
        return paymentService.getAllPayment();
    }

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }
}

