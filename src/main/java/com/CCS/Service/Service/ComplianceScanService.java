package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ComplianceScanRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceScanService {
	
	@Autowired
	private ComplianceScanRepo complianceScanRepo;
	
	public List<ComplianceScan> getAllComplianceScans(){
		 return complianceScanRepo.findAll();
	}
	
	public Optional<ComplianceScan> getComplianceScan(UUID id) {
		return complianceScanRepo.findById(id);
	}

	public ComplianceScan newComplianceScan(ComplianceScan complianceScan) {
		return  complianceScanRepo.save(complianceScan);
	}
	
	public void deleteComplianceScan(UUID id) {
		complianceScanRepo.deleteById(id);
	}
	
	public ComplianceScan UpdateComplianceScan(ComplianceScan complianceScan) {
		return complianceScanRepo.save(complianceScan);
	}
}
