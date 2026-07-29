package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.RiskPrediction;
@Repository

public interface RiskPredictionRepo extends JpaRepository<RiskPrediction,Long> {

}
