package com.shaku.salon_booking.Service;


import com.shaku.salon_booking.Model.Salon;
import com.shaku.salon_booking.Repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public Salon createSalon(Salon salon) {
        salon.setStatus("OPEN");
        return salonRepository.save(salon);
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon closeSalon(Long salonId) {
        Salon salon = salonRepository.findById(salonId)
                .orElseThrow(() -> new RuntimeException("Salon not found"));

        salon.setStatus("CLOSED");
        return salonRepository.save(salon);
    }
}

