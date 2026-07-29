package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.AIModelRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIModelService {
	
	@Autowired
	private AIModelRepo aIModelRepo;
	
	public List<AIModel> getAllAIModel(){
		 return aIModelRepo.findAll();
	}
	
	public Optional<AIModel> getAIModel(Long id) {
		return aIModelRepo.findById(id);
	}

	public AIModel newAIModel(AIModel aIModel) {
		return  aIModelRepo.save(aIModel);
	}
	
	public void deleteAIModel(Long id) {
		aIModelRepo.deleteById(id);
	}
	public AIModel UpdateAIModel(AIModel aIModel) {
		return aIModelRepo.save(aIModel);
	}
}
