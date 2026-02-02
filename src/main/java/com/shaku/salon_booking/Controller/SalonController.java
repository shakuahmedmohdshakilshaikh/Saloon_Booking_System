package com.shaku.salon_booking.Controller;


import com.shaku.salon_booking.Model.Salon;
import com.shaku.salon_booking.Service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salons")
@CrossOrigin(origins = "*")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        return salonService.createSalon(salon);
    }

    @GetMapping
    public List<Salon> getAllSalons() {
        return salonService.getAllSalons();
    }

    @PutMapping("/{id}/close")
    public Salon closeSalon(@PathVariable Long id) {
        return salonService.closeSalon(id);
    }
}
