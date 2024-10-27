package com.barbershop.barbershop_backend.services;

import com.barbershop.barbershop_backend.interfaces.IBarberShopRepository;
import com.barbershop.barbershop_backend.model.BarberShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BarberShopService {
    @Autowired
    private IBarberShopRepository barberShopRepository;

    public List<BarberShop> getAllBarberShop() {
        return barberShopRepository.getBarberShops();
    }

    public Optional<BarberShop> getBarberShopById(UUID id) {
        return barberShopRepository.getBarberShopById(id);
    }

    public BarberShop createBarberShop(BarberShop barberShop) {
        return barberShopRepository.createBarberShop(barberShop);
    }

    public BarberShop updateBarberShop(UUID id, BarberShop updateBarberShop) {
        return barberShopRepository.updateBarberShop(id, updateBarberShop);
    }

    public void deleteBarberShop(UUID id) {
        barberShopRepository.deleteBarberShop(id);
    }
}
