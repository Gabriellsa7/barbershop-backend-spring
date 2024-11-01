package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.model.HairCut;
import com.barbershop.barbershop_backend.services.HairCutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/haircuts")
public class HairCutController {
    @Autowired // Injects the HairCutService bean to handle business logic
    private HairCutService hairService;

    // Endpoint to retrieve all HairCuts from the database
    @GetMapping
    public List<HairCut> getAllHairCuts() {
        return hairService.getAllHairCuts(); // Calls the service to fetch all HairCuts
    }

    // Endpoint to get a HairCut by its unique UUID
    @GetMapping("/{id}")
    public ResponseEntity<HairCut> getHairCutById(@PathVariable UUID id) {
        Optional<HairCut> hairCut = hairService.getHairCutById(id); // Retrieves HairCut by ID
        // Returns 200 OK if found, or 404 Not Found if HairCut doesn't exist
        return hairCut.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to create a new HairCut
    @PostMapping
    public HairCut createHairCut(@RequestBody HairCut HairCut) {
        return hairService.createHairCut(HairCut); // Calls service to save the new HairCut
    }

    // Endpoint to update an existing HairCut by ID
    @PutMapping("/{id}")
    public ResponseEntity<HairCut> updateHairCut(@PathVariable UUID id, @RequestBody HairCut updatedHairCut) {
        try {
            // Tries to update the HairCut and returns 200 OK with updated HairCut if successful
            HairCut hairCut = hairService.updateHairCut(id, updatedHairCut);
            return ResponseEntity.ok(hairCut);
        } catch (RuntimeException e) {
            // Returns 404 Not Found if the HairCut with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a HairCut by its unique UUID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairCut(@PathVariable("id") UUID id) {
        hairService.deleteHairCut(id); // Calls service to delete the HairCut by ID
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}
