package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IHairCutReservationRepository;
import com.barbershop.barbershop_backend.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class HairCutReservationRepository implements IHairCutReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HairCutReservation createReservation(HairCutReservation reservation) {
        entityManager.persist(reservation);
        return reservation;
    }

    @Override
    @Query("SELECT c FROM HairCutReservation c")
    public List<HairCutReservation> getReservations() {
        return  entityManager.createQuery("SELECT c FROM HairCutReservation c", HairCutReservation.class).getResultList();
    }

    @Override
    public Optional<HairCutReservation> getReservationById(UUID id) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);
        return Optional.ofNullable(reservation);
    }

    @Override
    public HairCutReservation updateReservation(UUID id, HairCutReservation updateReservation) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);

        if(reservation != null) {
            reservation.setStatus(updateReservation.getStatus());
            reservation.setDateTime(updateReservation.getDateTime());
            reservation.setImgUrl(updateReservation.getImgUrl());
            reservation.setClient(updateReservation.getClient());
            reservation.setBarberShop(updateReservation.getBarberShop());
            reservation.setHairService(updateReservation.getHairService());
            entityManager.merge(reservation);
        }
        return reservation;
    }

    @Override
    public void deleteReservation(UUID id) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);

        if (reservation != null) {
            entityManager.remove(reservation);
        }
    }

    @Override
    public Optional<BarberShop> getBarberShopId(UUID barberShop_id) {
        return Optional.empty();
    }

    @Override
    public Optional<HairService> getHairServiceId(UUID hairService_id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getClientId(UUID client_id) {
        return Optional.empty();
    }
}

