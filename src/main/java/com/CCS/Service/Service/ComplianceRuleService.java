package com.CCS.Service.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ComplianceRuleRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceRuleService {

	
	@Autowired
	private ComplianceRuleRepo complianceRuleRepo;
	
	public List<ComplianceRule> getAllComplianceRules(){
		 return complianceRuleRepo.findAll();
	}
	
	public Optional<ComplianceRule> getComplianceRule(Long id) {
		return complianceRuleRepo.findById(id);
	}

	public ComplianceRule newComplianceRule(ComplianceRule complianceRule) {
		return  complianceRuleRepo.save(complianceRule);
	}
	
	public void deleteComplianceRule(Long id) {
		complianceRuleRepo.deleteById(id);
	}
	
	public ComplianceRule UpdateComplianceRule(ComplianceRule complianceRule) {
		return complianceRuleRepo.save(complianceRule);
	}
}

