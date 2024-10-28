package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.HairCut;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IHairCutRepository {
    HairCut createHairCut(HairCut hairCut);

    List<HairCut> getHairCuts();

    Optional<HairCut> getHairCutById(UUID id);

    HairCut updateHairCut(UUID id, HairCut updateHairCut);

    void deleteHairCut(UUID id);
}
