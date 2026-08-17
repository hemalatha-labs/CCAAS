package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.RiskPrediction;

public interface RiskPredictionRepo
        extends JpaRepository<RiskPrediction, UUID> {

}