package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.SimulationResult;
@Repository

public interface SimulationResultRepo extends JpaRepository<SimulationResult,Long> {

}
