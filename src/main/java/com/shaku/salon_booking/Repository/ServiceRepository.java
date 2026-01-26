package com.shaku.salon_booking.Repository;

import com.shaku.salon_booking.Model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findBySalon_Id(Long salonId);

    boolean existsByNameAndSalon_Id(String name, Long salonId);
}
