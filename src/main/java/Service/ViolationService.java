package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.ViolationRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViolationService {
	
	@Autowired
	private ViolationRepo violationRepo;
	
	public List<Violation> getAllViolations(){
		 return violationRepo.findAll();
	}
	
	public Optional<Violation> getViolation(Long id) {
		return violationRepo.findById(id);
	}

	public Violation newViolation(Violation violation) {
		return  violationRepo.save(violation);
	}
	
	public void deleteViolation(Long id) {
		violationRepo.deleteById(id);
	}
}
