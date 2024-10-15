package com.barbershop.barbershop_backend.repository;

import com.barbershop.barbershop_backend.interfaces.IHairCutRepository;
import com.barbershop.barbershop_backend.model.Client;
import com.barbershop.barbershop_backend.model.HairCut;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HairCurRepository implements IHairCutRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public HairCut createHairCut(HairCut hairCut) {
        entityManager.persist(hairCut);

        if(hairCut.getName() != null || hairCut.getBarberShop() != null) {
            return  hairCut;
        }
        return  null;
    }

    @Override
    public List<HairCut> getHairCuts() {
        return  entityManager.createQuery("SELECT u FROM client u", HairCut.class).getResultList();
    }

    @Override
    public Optional<HairCut> getHairCutById(String id) {
        HairCut hairCut = entityManager.find(HairCut.class, id);

        return Optional.ofNullable(hairCut);
    }

     @Override
    public HairCut updateHairCut(String id, HairCut updateHairCut) {
         HairCut hairCut = entityManager.find(HairCut.class, id);
         if (hairCut != null) {
            hairCut.setName(updateHairCut.getName());
            hairCut.setDescription(updateHairCut.getDescription());
            hairCut.setImgUrl(updateHairCut.getImgUrl());
            hairCut.setBarberShop(updateHairCut.getBarberShop());
            hairCut.setHairService(updateHairCut.getHairService());
            entityManager.merge(hairCut);
         }

         return hairCut;
    }

    @Override
    public void deleteHairCut(String id){
        HairCut hairCut = entityManager.find(HairCut.class, id);

        if(hairCut != null) {
            entityManager.remove(hairCut);
        }
    }

}