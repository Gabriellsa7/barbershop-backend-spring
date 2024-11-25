package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.model.Client;
import com.barbershop.barbershop_backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://10.0.2.2:9090")
@RestController // Marks this class as a Spring MVC controller where every method returns a JSON or XML response
@RequestMapping("/clients") // Defines the base URL path for all client-related endpoints
public class ClientController {

    @Autowired // Injects the ClientService bean to handle business logic
    private ClientService clientService;

    // Endpoint to retrieve all clients from the database
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients(); // Calls the service to fetch all clients
    }

    // Endpoint to get a client by its unique UUID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        Optional<Client> client = clientService.getClientById(id); // Retrieves client by ID
        // Returns 200 OK if found, or 404 Not Found if client doesn't exist
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to create a new client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client); // Calls service to save the new client
    }

    // Endpoint to update an existing client by ID
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id, @RequestBody Client updatedClient) {
        try {
            // Tries to update the client and returns 200 OK with updated client if successful
            Client client = clientService.updateClient(id, updatedClient);
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            // Returns 404 Not Found if the client with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a client by its unique UUID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") UUID id) {
        clientService.deleteClient(id); // Calls service to delete the client by ID
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}
