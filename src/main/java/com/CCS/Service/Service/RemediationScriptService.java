package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.RemediationScriptRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemediationScriptService {
	
	@Autowired
	private RemediationScriptRepo remediationScriptRepo;
	
	public List<RemediationScript> getAllRemediationScripts(){
		 return remediationScriptRepo.findAll();
	}
	
	public Optional<RemediationScript> getRemediationScript(Long id) {
		return remediationScriptRepo.findById(id);
	}

	public RemediationScript newRemediationScript(RemediationScript remediationScript) {
		return  remediationScriptRepo.save(remediationScript);
	}
	
	public void deleteRemediationScript(Long id) {
		remediationScriptRepo.deleteById(id);
	}
	
	public RemediationScript UpdateRemediationScript(RemediationScript remediationScript) {
		return remediationScriptRepo.save(remediationScript);
	}
}
