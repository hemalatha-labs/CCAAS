package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.SimulationRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationService {
	
	@Autowired
	private SimulationRepo simulationRepo;
	
	public List<Simulation> getAllSimulations(){
		 return simulationRepo.findAll();
	}
	
	public Optional<Simulation> getSimulation(UUID id) {
		return simulationRepo.findById(id);
	}

	public Simulation newSimulation(Simulation simulation) {
		return  simulationRepo.save(simulation);
	}
	
	public Simulation UpdateSimulation(Simulation simulation) {
		return simulationRepo.save(simulation);
	}
	
	public void deleteSimulation(UUID id) {
		simulationRepo.deleteById(id);
	}
}
