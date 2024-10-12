package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {
    // Method to create a new client
    Client createClient(Client client);

    // Method to retrieve a list of users
    List<Client> getClients();

    //Method to get a client by ID, returns an Optional<Client> because the client might not be found
    Optional<Client> getClientById(String id);

    //Update the client's information
    Client updateClient(String id, Client updatedClient);

    //Delete client by id
    void deleteClient(String id);
}
