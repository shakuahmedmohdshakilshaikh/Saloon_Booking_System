package com.shaku.salon_booking.Service;

import com.shaku.salon_booking.DTO.ServiceRequest;
import com.shaku.salon_booking.DTO.ServiceResponse;
import com.shaku.salon_booking.Model.Salon;
import com.shaku.salon_booking.Model.ServiceEntity;
import com.shaku.salon_booking.Repository.SalonRepository;
import com.shaku.salon_booking.Repository.ServiceRepository;
import com.shaku.salon_booking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public ServiceResponse createService(ServiceRequest request) {

        Salon salon = salonRepository.findById(request.getSalonId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Salon not found"));

        // Prevent duplicate service in same salon
        if (serviceRepository.existsByNameAndSalon_Id(
                request.getName(), request.getSalonId())) {
            throw new RuntimeException("Service already exists in this salon");
        }

        ServiceEntity service = new ServiceEntity();
        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setPrice(request.getPrice());
        service.setDurationMinutes(request.getDurationMinutes());
        service.setStatus(request.getStatus());
        service.setSalon(salon);

        ServiceEntity saved = serviceRepository.save(service);

        return mapToResponse(saved);
    }

    @Override
    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<ServiceResponse> getServicesBySalon(Long salonId) {
        return serviceRepository.findBySalon_Id(salonId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ServiceResponse getServiceById(Long id) {
        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Service not found"));

        return mapToResponse(service);
    }

    @Override
    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Service not found");
        }
        serviceRepository.deleteById(id);
    }

    // --------- Mapper ---------
    private ServiceResponse mapToResponse(ServiceEntity service) {
        ServiceResponse dto = new ServiceResponse();
        dto.setId(service.getId());
        dto.setName(service.getName());
        dto.setDescription(service.getDescription());
        dto.setPrice(service.getPrice());
        dto.setDurationMinutes(service.getDurationMinutes());
        dto.setStatus(service.getStatus());
        dto.setSalonName(service.getSalon().getName());
        return dto;
    }
}
