package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ComplianceBenchmarkRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceBenchmarkService {
	
	@Autowired
	private ComplianceBenchmarkRepo complianceBenchmarkRepo;
	
	public List<ComplianceBenchmark> getAllComplianceBenchmarks(){
		 return complianceBenchmarkRepo.findAll();
	}
	
	public Optional<ComplianceBenchmark> getComplianceBenchmark(Long id) {
		return complianceBenchmarkRepo.findById(id);
	}

	public ComplianceBenchmark newComplianceBenchmark(ComplianceBenchmark complianceBenchmark) {
		return  complianceBenchmarkRepo.save(complianceBenchmark);
	}
	
	public void deleteComplianceBenchmark(Long id) {
		complianceBenchmarkRepo.deleteById(id);
	}
	
	public ComplianceBenchmark UpdateComplianceBenchmark(ComplianceBenchmark complianceBenchmark) {
		return complianceBenchmarkRepo.save(complianceBenchmark);
	}
}
