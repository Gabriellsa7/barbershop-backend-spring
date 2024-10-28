package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IHairCutRepository;
import com.barbershop.barbershop_backend.model.HairCut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HairCutService {

    @Autowired
    private IHairCutRepository hairCutRepository;

    // Method to retrieve all clients from the repository (database)
    public List<HairCut> getAllHairCuts() {
        return hairCutRepository.getHairCuts(); // Calls repository to fetch all HairCuts
    }

    // Method to get a HairCut by its unique UUID from the repository
    public Optional<HairCut> getHairCutById(UUID id) {
        return hairCutRepository.getHairCutById(id); // Calls repository to retrieve a HairCut by ID
    }

    // Method to create and save a new HairCut to the repository
    public HairCut createHairCut(HairCut HairCut) {
        return hairCutRepository.createHairCut(HairCut); // Calls repository to save the new HairCut
    }

    // Method to update an existing HairCut by its UUID
    public HairCut updateHairCut(UUID id, HairCut updatedHairCut) {
        return hairCutRepository.updateHairCut(id, updatedHairCut); // Calls repository to update HairCut data
    }

    // Method to delete a HairCut by its unique UUID from the repository
    public void deleteHairCut(UUID id) {
        hairCutRepository.deleteHairCut(id); // Calls repository to delete the HairCut by ID
    }
}
