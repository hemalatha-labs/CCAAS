package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.SimulationResultRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationResultService {
	
	@Autowired
	private SimulationResultRepo simulationResultRepo;
	
	public List<SimulationResult> getAllSimulationResults(){
		 return simulationResultRepo.findAll();
	}
	
	public Optional<SimulationResult> getSimulationResult(UUID id) {
		return simulationResultRepo.findById(id);
	}

	public SimulationResult newSimulationResult(SimulationResult simulationResult) {
		return  simulationResultRepo.save(simulationResult);
	}
	
	public SimulationResult UpdateSimulationResult(SimulationResult simulationResult) {
		return simulationResultRepo.save(simulationResult);
	}
	
	public void deleteSimulationResult(UUID id) {
		simulationResultRepo.deleteById(id);
	}
	
}
