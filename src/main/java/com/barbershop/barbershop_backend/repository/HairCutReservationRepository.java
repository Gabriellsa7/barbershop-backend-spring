package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IHairCutReservationRepository;
import com.barbershop.barbershop_backend.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public List<HairCutReservation> getReservations() {
        return  entityManager.createQuery("SELECT u FROM client u", HairCutReservation.class).getResultList();
    }

    @Override
    public Optional<HairCutReservation> getReservationById(String id) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);

        return Optional.ofNullable(reservation);
    }

    @Override
    public HairCutReservation updateReservation(String id, HairCutReservation updateReservation) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);

        if(reservation != null) {
            reservation.setStatus(updateReservation.getStatus());
            reservation.setDateTime(updateReservation.getDateTime());
            reservation.setImgUrl(updateReservation.getImgUrl());
            reservation.setClient(updateReservation.getClient());
            reservation.setBarberShop(updateReservation.getBarberShop());
            reservation.setService(updateReservation.getService());
            entityManager.merge(reservation);
        }
        return reservation;
    }

    @Override
    public void deleteReservation(String id) {
        HairCutReservation reservation = entityManager.find(HairCutReservation.class, id);

        if (reservation != null) {
            entityManager.remove(reservation);
        }
    }

    @Override
    public Optional<BarberShop> getBarberShopId(String barberShop_id) {
        return Optional.empty();
    }

    @Override
    public Optional<HairService> getHairServiceId(String hairService_id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getClientId(String client_id) {
        return Optional.empty();
    }
}

