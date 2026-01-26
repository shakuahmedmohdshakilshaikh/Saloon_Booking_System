package com.shaku.salon_booking.Service;


import com.shaku.salon_booking.Model.Salon;

import java.util.List;

public interface SalonService {

    Salon createSalon(Salon salon);

    List<Salon> getAllSalons();

    Salon closeSalon(Long salonId);
}

