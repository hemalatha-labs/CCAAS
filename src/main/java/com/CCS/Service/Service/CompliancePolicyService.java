package com.CCS.Service.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.CompliancePolicyRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompliancePolicyService {

	
	@Autowired
	private CompliancePolicyRepo compliancePolicyRepo;
	
	public List<CompliancePolicy> getAllCompliancePolicies(){
		 return compliancePolicyRepo.findAll();
	}
	
	public Optional<CompliancePolicy> getCompliancePolicy(Long id) {
		return compliancePolicyRepo.findById(id);
	}

	public CompliancePolicy newCompliancePolicy(CompliancePolicy compliancePolicy) {
		return  compliancePolicyRepo.save(compliancePolicy);
	}
	
	public CompliancePolicy UpdateCompliancePolicy(CompliancePolicy compliancePolicy) {
		return compliancePolicyRepo.save(compliancePolicy);
	}
	
	public void deleteCompliancePolicy(Long id) {
		compliancePolicyRepo.deleteById(id);
	}
}


