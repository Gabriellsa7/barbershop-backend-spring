package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.HairService;

import java.util.List;
import java.util.Optional;

public interface IHairServiceRepository {

    HairService createService(HairService hairService);

    List<HairService> getServices();

    Optional<HairService> getServiceById(String id);

    HairService updateService(String id, HairService updateService);

    void deleteService(String id);
}
