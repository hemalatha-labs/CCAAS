package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.Simulation;

public interface SimulationRepo
        extends JpaRepository<Simulation, UUID> {

}