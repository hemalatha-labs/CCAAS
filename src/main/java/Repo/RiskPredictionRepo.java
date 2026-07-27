package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.RiskPrediction;
@Repository

public interface RiskPredictionRepo extends JpaRepository<RiskPrediction,Long> {

}
