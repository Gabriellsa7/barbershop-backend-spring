package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.infra.security.JwtUtil;
import com.barbershop.barbershop_backend.model.Client;
import com.barbershop.barbershop_backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client loginRequest) {
        Optional<Client> clientOptional = clientService.getClientByEmail(loginRequest.getEmail());

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            // Verifica se a senha do banco coincide com a senha fornecida
            if (client.getPassword().equals(loginRequest.getPassword())) {
                String token = jwtUtil.generateToken(client.getEmail());
                return ResponseEntity.ok(token); // Retorna o token JWT
            } else {
                return ResponseEntity.status(401).body("Invalid password");
            }
        }
        return ResponseEntity.status(401).body("User not found");
    }
}