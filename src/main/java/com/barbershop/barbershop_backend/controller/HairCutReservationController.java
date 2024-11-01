package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.model.HairCutReservation;
import com.barbershop.barbershop_backend.services.HairCutReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class HairCutReservationController {

    @Autowired // Injects the HairCutReservationService bean to handle business logic
    private HairCutReservationService hairCutReservationService;

    // Endpoint to retrieve all HairCutReservations from the database
    @GetMapping
    public List<HairCutReservation> getAllHairCutReservations() {
        return hairCutReservationService.getAllHairCutReservations(); // Calls the service to fetch all HairCutReservations
    }

    // Endpoint to get a HairCutReservation by its unique UUID
    @GetMapping("/{id}")
    public ResponseEntity<HairCutReservation> getHairCutReservationById(@PathVariable UUID id) {
        Optional<HairCutReservation> hairCutReservation = hairCutReservationService.getHairCutReservationById(id); // Retrieves HairCutReservation by ID
        // Returns 200 OK if found, or 404 Not Found if HairCutReservation doesn't exist
        return hairCutReservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to create a new HairCutReservation
    @PostMapping
    public HairCutReservation createHairCutReservation(@RequestBody HairCutReservation HairCutReservation) {
        return hairCutReservationService.createHairCutReservation(HairCutReservation); // Calls service to save the new HairCutReservation
    }

    // Endpoint to update an existing HairCutReservation by ID
    @PutMapping("/{id}")
    public ResponseEntity<HairCutReservation> updateHairCutReservation(@PathVariable UUID id, @RequestBody HairCutReservation updatedHairCutReservation) {
        try {
            // Tries to update the HairCutReservation and returns 200 OK with updated HairCutReservation if successful
            HairCutReservation hairCutReservation = hairCutReservationService.updateHairCutReservation(id, updatedHairCutReservation);
            return ResponseEntity.ok(hairCutReservation);
        } catch (RuntimeException e) {
            // Returns 404 Not Found if the HairCutReservation with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a HairCutReservation by its unique UUID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairCutReservation(@PathVariable("id") UUID id) {
        hairCutReservationService.deleteHairCutReservation(id); // Calls service to delete the HairCutReservation by ID
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}
