package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IClientRepository;
import com.barbershop.barbershop_backend.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private IClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.getClients();
    }

    public Optional<Client> getClientById(UUID id) {
        return clientRepository.getClientById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.createClient(client);
    }

    public Client updateClient(UUID id, Client updatedClient) {
        return clientRepository.updateClient(id, updatedClient);
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteClient(id);
    }
}
