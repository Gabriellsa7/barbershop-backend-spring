package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IHairServiceRepository;
import com.barbershop.barbershop_backend.model.HairService;
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
public class HairServiceRepository  implements IHairServiceRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public HairService createService(HairService hairService) {
        entityManager.persist(hairService);

        if(hairService.getName() != null || hairService.getBarberShop() != null || hairService.getHairCuts() != null || hairService.getHairCutReservation() != null) {
            return hairService;
        }
        return null;
    }

    @Override
    @Query("SELECT c FROM HairService c")
    public List<HairService> getServices() {
        return entityManager.createQuery("SELECT c FROM HairService c", HairService.class).getResultList();
    }

    @Override
    public Optional<HairService> getServiceById(UUID id) {
        HairService hairService = entityManager.find(HairService.class, id);

        return Optional.ofNullable(hairService);
    }

    @Override
    public HairService updateService(UUID id, HairService updateService) {
        HairService hairService = entityManager.find(HairService.class, id);

        if(hairService != null) {
            hairService.setName(updateService.getName());
            hairService.setDescription(updateService.getDescription());
            hairService.setBarberShop(updateService.getBarberShop());
            hairService.setDuration(updateService.getDuration());
            hairService.setHairCutReservation(updateService.getHairCutReservation());
            hairService.setHairCuts(updateService.getHairCuts());
            hairService.setPrice(updateService.getPrice());
        }

        return hairService;
    }

    @Override
    public void deleteService(UUID id) {
        HairService hairService = entityManager.find(HairService.class, id);

        if (hairService != null) {
            entityManager.remove(hairService);
        }
    }
}
