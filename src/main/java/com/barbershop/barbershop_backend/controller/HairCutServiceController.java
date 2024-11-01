package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.model.HairService;
import com.barbershop.barbershop_backend.services.HairServiceService;
import com.barbershop.barbershop_backend.services.HairServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class HairCutServiceController {

    @Autowired // Injects the HairServiceService bean to handle business logic
    private HairServiceService hairServiceService;

    // Endpoint to retrieve all HairServices from the database
    @GetMapping
    public List<HairService> getAllHairServices() {
        return hairServiceService.getAllHairServices(); // Calls the service to fetch all HairServices
    }

    // Endpoint to get a HairService by its unique UUID
    @GetMapping("/{id}")
    public ResponseEntity<HairService> getHairServiceById(@PathVariable UUID id) {
        Optional<HairService> hairService = hairServiceService.getHairServiceById(id); // Retrieves HairService by ID
        // Returns 200 OK if found, or 404 Not Found if HairService doesn't exist
        return hairService.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to create a new HairService
    @PostMapping
    public HairService createHairService(@RequestBody HairService HairService) {
        return hairServiceService.createHairService(HairService); // Calls service to save the new HairService
    }

    // Endpoint to update an existing HairService by ID
    @PutMapping("/{id}")
    public ResponseEntity<HairService> updateHairService(@PathVariable UUID id, @RequestBody HairService updatedHairService) {
        try {
            // Tries to update the HairService and returns 200 OK with updated HairService if successful
            HairService hairService = hairServiceService.updateHairService(id, updatedHairService);
            return ResponseEntity.ok(hairService);
        } catch (RuntimeException e) {
            // Returns 404 Not Found if the HairService with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a HairService by its unique UUID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairService(@PathVariable("id") UUID id) {
        hairServiceService.deleteHairService(id); // Calls service to delete the HairService by ID
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}
