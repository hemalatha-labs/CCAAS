package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Simulation;
@Repository

public interface SimulationRepo extends JpaRepository<Simulation,Long> {

}
