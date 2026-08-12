package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.AIChatSessionRepo;
import com.CCS.Service.model.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AIChatSessionService {
	
	@Autowired
	private AIChatSessionRepo aIChatSessionRepo;

	AIChatSessionService(AIChatSessionRepo aIChatSessionRepo) {
		this.aIChatSessionRepo = aIChatSessionRepo;
	}
	
	public List<AIChatSession> getAllAIChatSessions(){
		 return aIChatSessionRepo.findAll();
	}
	
	public Optional<AIChatSession> getAIChatSession(UUID id) {
		return aIChatSessionRepo.findById(id);
	}

	public AIChatSession newAIChatSession(AIChatSession aIChatSession) {
		return  aIChatSessionRepo.save(aIChatSession);
	}
	
	public void deleteAIChatSession(UUID id) {
		aIChatSessionRepo.deleteById(id);
	}
	
	public AIChatSession UpdateAIChatSession(AIChatSession aIChatSession) {
		return aIChatSessionRepo.save(aIChatSession);
	}
}
