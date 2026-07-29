package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.ResourceTagRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourceTagService {

	
	@Autowired
	private ResourceTagRepo resourceTagRepo;
	
	public List<ResourceTag> getAllResourceTags(){
		 return resourceTagRepo.findAll();
	}
	
	public Optional<ResourceTag> getResourceTag(Long id) {
		return resourceTagRepo.findById(id);
	}

	public ResourceTag newResourceTag(ResourceTag resourceTag) {
		return  resourceTagRepo.save(resourceTag);
	}
	
	public void deleteResourceTag(Long id) {
		resourceTagRepo.deleteById(id);
	}
	
	public ResourceTag UpdateResourceTag(ResourceTag resourceTag) {
		return resourceTagRepo.save(resourceTag);
	}
}