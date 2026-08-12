package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.CloudAccountRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudAccountService {

	
	@Autowired
	private CloudAccountRepo cloudAccountRepo;
	
	public List<CloudAccount> getAllCloudAccount(){
		 return cloudAccountRepo.findAll();
	}
	
	public Optional<CloudAccount> getCloudAccount(UUID id) {
		return cloudAccountRepo.findById(id);
	}

	public CloudAccount newCloudAccount(CloudAccount cloudAccount) {
		return  cloudAccountRepo.save(cloudAccount);
	}
	
	public void deleteCloudAccount(UUID id) {
		cloudAccountRepo.deleteById(id);
	}
	
	public CloudAccount UpdateCloudAccount(CloudAccount cloudAccount) {
		return cloudAccountRepo.save(cloudAccount);
	}
}
