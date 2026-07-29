package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ViolationRepo;
import com.CCS.Service.model.*;

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
	
	public Violation UpdateViolation(Violation violation) {
		return violationRepo.save(violation);
	}
	
	public void deleteViolation(Long id) {
		violationRepo.deleteById(id);
	}
}
