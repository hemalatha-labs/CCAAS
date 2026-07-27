package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.SimulationResultRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationResultService {
	
	@Autowired
	private SimulationResultRepo simulationResultRepo;
	
	public List<SimulationResult> getAllSimulationResults(){
		 return simulationResultRepo.findAll();
	}
	
	public Optional<SimulationResult> getSimulationResult(Long id) {
		return simulationResultRepo.findById(id);
	}

	public SimulationResult newUser(SimulationResult simulationResult) {
		return  simulationResultRepo.save(simulationResult);
	}
	
	public void deleteSimulationResult(Long id) {
		simulationResultRepo.deleteById(id);
	}
}
