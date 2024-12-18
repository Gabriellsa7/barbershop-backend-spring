package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IClientRepository;
import com.barbershop.barbershop_backend.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class ClientRepository implements IClientRepository {

    // Injecting the EntityManager to interact with the database
    @PersistenceContext
    private EntityManager entityManager;

    // Method to create a new client in the database
    @Override
    public Client createClient(Client client) {
        entityManager.persist(client); // Persist the client entity to the database
        return client; // Return the saved client object
    }

    // Method to retrieve all clients from the database
    @Override
    @Query("SELECT c FROM Client c")
    public List<Client> getClients() {
        // Running a JPQL query to select all clients from the User table (Client entity)
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    // Method to get a client by their ID
    @Override
    public Optional<Client> getClientById(UUID id) {
        // Find the client by primary key (ID) in the database
        Client client = entityManager.find(Client.class, id);
        // Return an Optional containing the client if found, or empty if not found
        return Optional.ofNullable(client);
    }

    // Method to update a client with new information
    @Override
    public Client updateClient(UUID id, Client updatedClient) {
        // Find the client by ID in the database
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            // If the client exists, update their details with the new data
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            client.setPassword(updatedClient.getPassword());
            entityManager.merge(client); // Merge the updated client object into the persistence context
        }
        return client; // Return the updated client or null if the client was not found
    }

    // Method to delete a client by their ID
    @Override
    public void deleteClient(UUID id) {
        // Find the client by ID
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            // If the client exists, remove them from the database
            entityManager.remove(client);
        }
    }

    public Optional<Client> findByEmail(String email) {
        return entityManager.createQuery(
                        "SELECT c FROM Client c WHERE LOWER(c.email) = LOWER(:email)", Client.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
