package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IHairCutReservationRepository;
import com.barbershop.barbershop_backend.interfaces.IHairCutReservationRepository;
import com.barbershop.barbershop_backend.model.Client;
import com.barbershop.barbershop_backend.model.HairCutReservation;
import com.barbershop.barbershop_backend.repository.HairCutReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HairCutReservationService {
    @Autowired // Injects the IHairCutReservationRepository dependency to handle database operations
    private IHairCutReservationRepository hairCutReservationRepository;
    private ClientService clientService;

    public HairCutReservationService(ClientService clientService, HairCutReservationRepository reservationRepository) {
        this.clientService = clientService;
        this.hairCutReservationRepository = reservationRepository;
    }

    // Method to retrieve all HairCutReservations from the repository (database)
    public List<HairCutReservation> getAllHairCutReservations() {
        return hairCutReservationRepository.getReservations(); // Calls repository to fetch all HairCutReservations
    }

    // Method to get a HairCutReservation by its unique UUID from the repository
    public Optional<HairCutReservation> getHairCutReservationById(UUID id) {
        return hairCutReservationRepository.getReservationById(id); // Calls repository to retrieve a HairCutReservation by ID
    }

    // Method to create and save a new HairCutReservation to the repository
    public HairCutReservation createHairCutReservation(HairCutReservation hairCutReservation) {
        return hairCutReservationRepository.createReservation(hairCutReservation); // Calls repository to save the new HairCutReservation
    }

    // Method to update an existing HairCutReservation by its UUID
    public HairCutReservation updateHairCutReservation(UUID id, HairCutReservation updatedHairCutReservation) {
        return hairCutReservationRepository.updateReservation(id, updatedHairCutReservation); // Calls repository to update HairCutReservation data
    }

    // Method to delete a HairCutReservation by its unique UUID from the repository
    public void deleteHairCutReservation(UUID id) {
        hairCutReservationRepository.deleteReservation(id); // Calls repository to delete the HairCutReservation by ID
    }
}
