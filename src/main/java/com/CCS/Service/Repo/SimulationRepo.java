package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.Simulation;
@Repository

public interface SimulationRepo extends JpaRepository<Simulation,Long> {

}
