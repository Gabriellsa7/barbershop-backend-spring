package com.barbershop.barbershop_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "haircut")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairCut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", referencedColumnName = "id")
    private BarberShop barberShop;

    @ManyToOne
    @JoinColumn(name = "hair_service_id", referencedColumnName = "id")
    private HairService hairService;
}
