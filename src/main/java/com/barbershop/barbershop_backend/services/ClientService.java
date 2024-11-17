package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IClientRepository;
import com.barbershop.barbershop_backend.model.Client;
import com.barbershop.barbershop_backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // Marks this class as a Spring service, indicating it's part of the service layer
public class ClientService {

    @Autowired // Injects the IClientRepository dependency to handle database operations
    private ClientRepository clientRepository;

    // Method to retrieve all clients from the repository (database)
    public List<Client> getAllClients() {
        return clientRepository.getClients(); // Calls repository to fetch all clients
    }

    // Method to get a client by its unique UUID from the repository
    public Optional<Client> getClientById(UUID id) {
        return clientRepository.getClientById(id); // Calls repository to retrieve a client by ID
    }

    // Method to create and save a new client to the repository
    public Client createClient(Client client) {
        return clientRepository.createClient(client); // Calls repository to save the new client
    }

    // Method to update an existing client by its UUID
    public Client updateClient(UUID id, Client updatedClient) {
        return clientRepository.updateClient(id, updatedClient); // Calls repository to update client data
    }

    // Method to delete a client by its unique UUID from the repository
    public void deleteClient(UUID id) {
        clientRepository.deleteClient(id); // Calls repository to delete the client by ID
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}

