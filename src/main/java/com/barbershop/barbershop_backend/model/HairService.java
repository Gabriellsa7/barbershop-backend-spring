package com.barbershop.barbershop_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "hair_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairService {

    @Id
    @GeneratedValue(generator = "UUID")
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

    @OneToMany(mappedBy = "hairService")
    private List<HairCutReservation> hairCutReservation;

    @OneToMany(mappedBy = "hairService")
    private List<HairCut> hairCuts;

}
