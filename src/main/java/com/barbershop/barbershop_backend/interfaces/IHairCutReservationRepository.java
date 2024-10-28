package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IHairCutReservationRepository {
    HairCutReservation createReservation(HairCutReservation reservation);

    List<HairCutReservation> getReservations();

    Optional<HairCutReservation> getReservationById(UUID id);

    HairCutReservation updateReservation(UUID id, HairCutReservation updateReservation);

    void deleteReservation (UUID id);

    //method to get a barbershop ID, used in a validation
    Optional<BarberShop> getBarberShopId(UUID barberShop_id);
    //method to get a hair service ID, used in a validation
    Optional<HairService> getHairServiceId(UUID hairService_id);
    //method to get a client ID, used in a validation
    Optional<Client> getClientId(UUID client_id);
}
