package com.barbershop.barbershop_backend.controller;

import com.barbershop.barbershop_backend.model.BarberShop;
import com.barbershop.barbershop_backend.services.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/barbershop")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @GetMapping
    public List<BarberShop> getAllBarberShops() {
        return barberShopService.getAllBarberShop();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShop> getBarberShopById(@PathVariable UUID id) {
        Optional<BarberShop> barberShop = barberShopService.getBarberShopById(id);
        return barberShop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BarberShop createBarberShop(@RequestBody BarberShop barberShop) {
        return barberShopService.createBarberShop(barberShop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarberShop(@PathVariable("id") UUID id) {
        barberShopService.deleteBarberShop(id);
        return ResponseEntity.ok().build();
    }
}
