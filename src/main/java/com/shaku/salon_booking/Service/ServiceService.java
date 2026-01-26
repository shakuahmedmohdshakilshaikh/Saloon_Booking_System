package com.shaku.salon_booking.Service;

import com.shaku.salon_booking.DTO.ServiceRequest;
import com.shaku.salon_booking.DTO.ServiceResponse;

import java.util.List;

public interface ServiceService {

    ServiceResponse createService(ServiceRequest request);

    List<ServiceResponse> getAllServices();

    List<ServiceResponse> getServicesBySalon(Long salonId);

    ServiceResponse getServiceById(Long id);

    void deleteService(Long id);
}
