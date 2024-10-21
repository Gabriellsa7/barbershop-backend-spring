package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.BarberShop;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBarberShopRepository {

    BarberShop createBarberShop(BarberShop barberShop);

    List<BarberShop> getBarberShops();

    Optional<BarberShop> getBarberShopById(UUID id);

    BarberShop updateBarberShop(UUID id, BarberShop updateBarberShop);

    void deleteBarberShop(UUID id);
}
