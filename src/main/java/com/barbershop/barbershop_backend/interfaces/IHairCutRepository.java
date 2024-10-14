package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.HairCut;

import java.util.List;
import java.util.Optional;

public interface IHairCutRepository {
    HairCut createHairCut(HairCut hairCut);

    List<HairCut> getHairCuts();

    Optional<HairCut> getHairCutById(String id);

    HairCut updateHairCut(String id, HairCut updateHairCut);

    void deleteHairCut(String id);
}
