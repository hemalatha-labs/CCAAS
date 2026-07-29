package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.SimulationResult;
@Repository

public interface SimulationResultRepo extends JpaRepository<SimulationResult,Long> {

}
