package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.CloudResourceRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudResourceService{

	
	@Autowired
	private CloudResourceRepo cloudResourceRepo;
	
	public List<CloudResource> getAllCloudResources(){
		 return cloudResourceRepo.findAll();
	}
	
	public Optional<CloudResource> getCloudResource(UUID id) {
		return cloudResourceRepo.findById(id);
	}

	public CloudResource newCloudResource(CloudResource cloudResource) {
		return  cloudResourceRepo.save(cloudResource);
	}
	
	public void deleteCloudResource(UUID id) {
		cloudResourceRepo.deleteById(id);
	}
	
	public CloudResource UpdateCloudResource(CloudResource cloudResource) {
		return cloudResourceRepo.save(cloudResource);
	}
}


