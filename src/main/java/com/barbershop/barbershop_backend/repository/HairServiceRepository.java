package com.barbershop.barbershop_backend.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Entity
@Transactional
public class HairServiceRepository {
    @PersistenceContext
    private EntityManager entityManager;
}
