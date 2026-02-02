package com.shaku.salon_booking.Controller;

import com.shaku.salon_booking.DTO.ServiceRequest;
import com.shaku.salon_booking.DTO.ServiceResponse;
import com.shaku.salon_booking.Service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceResponse> createService(@Valid @RequestBody ServiceRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceService.createService(request));
    }

    @GetMapping
    public ResponseEntity<List<ServiceResponse>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }



    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getServiceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<List<ServiceResponse>> getServicesBySalon(
            @PathVariable Long salonId) {

        return ResponseEntity.ok(
                serviceService.getServicesBySalon(salonId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
