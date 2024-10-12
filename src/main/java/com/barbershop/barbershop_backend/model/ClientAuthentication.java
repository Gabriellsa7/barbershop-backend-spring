package com.barbershop.barbershop_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client_authentication")
// Data Lombok add setters and getters
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAuthentication {

    @Id
    @UuidGenerator
    private UUID id;

    private String token;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private Client client;
}
