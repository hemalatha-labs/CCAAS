package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.SimulationRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationService {
	
	@Autowired
	private SimulationRepo simulationRepo;
	
	public List<Simulation> getAllSimulations(){
		 return simulationRepo.findAll();
	}
	
	public Optional<Simulation> getSimulation(Long id) {
		return simulationRepo.findById(id);
	}

	public Simulation newSimulation(Simulation simulation) {
		return  simulationRepo.save(simulation);
	}
	
	public void deleteSimulation(Long id) {
		simulationRepo.deleteById(id);
	}
}
