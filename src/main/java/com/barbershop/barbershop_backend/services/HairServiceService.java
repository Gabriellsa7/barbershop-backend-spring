package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IHairServiceRepository;
import com.barbershop.barbershop_backend.model.HairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HairServiceService {
    @Autowired // Injects the IHairServiceRepository dependency to handle database operations
    private IHairServiceRepository hairServiceRepository;

    // Method to retrieve all HairServices from the repository (database)
    public List<HairService> getAllHairServices() {
        return hairServiceRepository.getServices(); // Calls repository to fetch all HairServices
    }

    // Method to get a HairService by its unique UUID from the repository
    public Optional<HairService> getHairServiceById(UUID id) {
        return hairServiceRepository.getServiceById(id); // Calls repository to retrieve a HairService by ID
    }

    // Method to create and save a new HairService to the repository
    public HairService createHairService(HairService HairService) {
        return hairServiceRepository.createService(HairService); // Calls repository to save the new HairService
    }

    // Method to update an existing HairService by its UUID
    public HairService updateHairService(UUID id, HairService updatedHairService) {
        return hairServiceRepository.updateService(id, updatedHairService); // Calls repository to update HairService data
    }

    // Method to delete a HairService by its unique UUID from the repository
    public void deleteHairService(UUID id) {
        hairServiceRepository.deleteService(id); // Calls repository to delete the HairService by ID
    }
}
