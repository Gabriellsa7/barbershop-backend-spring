package com.barbershop.barbershop_backend.interfaces;

import com.barbershop.barbershop_backend.model.HairService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IHairServiceRepository {

    HairService createService(HairService hairService);

    List<HairService> getServices();

    Optional<HairService> getServiceById(UUID id);

    HairService updateService(UUID id, HairService updateService);

    void deleteService(UUID id);
}
