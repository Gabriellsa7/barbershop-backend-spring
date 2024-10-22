package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IBarberShopRepository;
import com.barbershop.barbershop_backend.model.BarberShop;
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
public class BarberShopRepository implements IBarberShopRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BarberShop createBarberShop(BarberShop barberShop) {
        entityManager.persist(barberShop);
        return  barberShop;
    }

    @Override
    @Query("SELECT c FROM BarberShop c")
    public List<BarberShop> getBarberShops() {
        return entityManager.createQuery("SELECT c FROM BarberShop c", BarberShop.class).getResultList();
    }

    @Override
    public Optional<BarberShop> getBarberShopById(UUID id) {
        BarberShop barberShop = entityManager.find(BarberShop.class, id);
        return Optional.ofNullable(barberShop);
    }

    @Override
    public  BarberShop updateBarberShop(UUID id, BarberShop updateBarberShop) {
        BarberShop barberShop = entityManager.find(BarberShop.class, id);
            if (barberShop != null) {
                barberShop.setName(updateBarberShop.getName());
                barberShop.setAddress(updateBarberShop.getAddress());
                barberShop.setDescription(updateBarberShop.getDescription());
                barberShop.setRating(updateBarberShop.getRating());
                barberShop.setClosingTime(updateBarberShop.getClosingTime());
                barberShop.setOpening_time(updateBarberShop.getOpening_time());
                entityManager.merge(barberShop);
            }
        return  barberShop;
    }

    @Override
    public void deleteBarberShop(UUID id) {
        BarberShop barberShop = entityManager.find(BarberShop.class, id);
        if(barberShop != null) {
            entityManager.remove(barberShop);
        }
    }
}
