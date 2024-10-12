package com.barbershop.barbershop_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "barbershop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarberShop {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "opening_time")
    private LocalTime opening_time;

    @Column(name = "closingTime")
    private LocalTime closingTime;

    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HairService> hairServices;

    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HairCut> hairCuts;

    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HairCutReservation> reservations;
}
