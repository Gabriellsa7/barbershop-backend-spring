package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.BarberShop;

import java.util.List;
import java.util.Optional;

public interface IBarberShopRepository {

    BarberShop createBarberShop(BarberShop barberShop);

    List<BarberShop> getBarberShops();

    Optional<BarberShop> getBarberShopById(String id);

    BarberShop updateBarberShop(String id, BarberShop updateBarberShop);

    void deleteBarberShop(String id);
}
