package com.barbershop.barbershop_backend.model;

import com.barbershop.barbershop_backend.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "hair_cut_reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairCutReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "img_url") //Allows field to be null if needed
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "barberShop_id", referencedColumnName = "id")
    private BarberShop barberShop;

    @ManyToOne
    @JoinColumn(name = "hair_service_id", referencedColumnName = "id")
    private HairService hairService;

    @OneToOne(mappedBy = "hairCutReservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;
}
