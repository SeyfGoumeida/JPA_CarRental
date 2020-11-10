package com.efrei.JPAExample;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

    List<Vehicule> findByplateNumber(String plateNumber);

}