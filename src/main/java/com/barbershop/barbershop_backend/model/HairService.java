package com.barbershop.barbershop_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "hair_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairService {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", referencedColumnName = "id")
    private BarberShop barberShop;

    @OneToOne(mappedBy = "hair_service", cascade = CascadeType.ALL, orphanRemoval = true)
    private HairCutReservation hairCutReservation;

    @OneToOne(mappedBy = "hair_service", cascade = CascadeType.ALL, orphanRemoval = true)
    private HairCut hairCut;



}
