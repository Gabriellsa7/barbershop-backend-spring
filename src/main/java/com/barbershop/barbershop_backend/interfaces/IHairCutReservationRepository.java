package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.*;

import java.util.List;
import java.util.Optional;

public interface IHairCutReservationRepository {
    HairCutReservation createReservation(HairCutReservation reservation);

    List<HairCutReservation> getReservations();

    Optional<HairCutReservation> getReservationById(String id);

    HairCutReservation updateReservation(String id, HairCutReservation updateReservation);

    void deleteReservation (String id);

    //method to get a barbershop ID, used in a validation
    Optional<BarberShop> getBarberShopId(String barberShop_id);
    //method to get a hair service ID, used in a validation
    Optional<HairService> getHairServiceId(String hairService_id);
    //method to get a client ID, used in a validation
    Optional<Client> getClientId(String client_id);
}
