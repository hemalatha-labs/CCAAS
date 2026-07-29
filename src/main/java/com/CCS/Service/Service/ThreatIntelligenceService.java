package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ThreatIntelligenceRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThreatIntelligenceService {
	
	@Autowired
	private ThreatIntelligenceRepo threatIntelligenceRepo;
	
	public List<ThreatIntelligence> getAllThreatIntelligences(){
		 return threatIntelligenceRepo.findAll();
	}
	
	public Optional<ThreatIntelligence> getThreatIntelligence(Long id) {
		return threatIntelligenceRepo.findById(id);
	}

	public ThreatIntelligence newThreatIntelligence(ThreatIntelligence threatIntelligence) {
		return  threatIntelligenceRepo.save(threatIntelligence);
	}
	
	public ThreatIntelligence UpdateThreatIntelligence(ThreatIntelligence threatIntelligence) {
		return threatIntelligenceRepo.save(threatIntelligence);
	}
	
	public void deleteThreatIntelligence(Long id) {
		threatIntelligenceRepo.deleteById(id);
	}
}
