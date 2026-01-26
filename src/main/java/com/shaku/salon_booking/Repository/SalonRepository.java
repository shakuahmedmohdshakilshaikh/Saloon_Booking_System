package com.shaku.salon_booking.Repository;


import com.shaku.salon_booking.Model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {
}

