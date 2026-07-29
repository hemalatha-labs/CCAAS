package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.RiskPredictionRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiskPredictionService {
	
	@Autowired
	private RiskPredictionRepo riskPredictionRepo;
	
	public List<RiskPrediction> getAllRiskPredictions(){
		 return riskPredictionRepo.findAll();
	}
	
	public Optional<RiskPrediction> getRiskPrediction(Long id) {
		return riskPredictionRepo.findById(id);
	}

	public RiskPrediction newRiskPrediction(RiskPrediction riskPrediction) {
		return  riskPredictionRepo.save(riskPrediction);
	}
	
	public void deleteRiskPrediction(Long id) {
		riskPredictionRepo.deleteById(id);
	}
	
	public RiskPrediction UpdateRiskPrediction(RiskPrediction riskPrediction) {
		return riskPredictionRepo.save(riskPrediction);
	}
}
