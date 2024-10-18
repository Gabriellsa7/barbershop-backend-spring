package com.barbershop.barbershop_backend.model;

import com.barbershop.barbershop_backend.enums.PaymentMethod;
import com.barbershop.barbershop_backend.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "value", nullable = false)
    private Float value;

    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false, referencedColumnName = "id")
    private  HairCutReservation hairCutReservation;
}
