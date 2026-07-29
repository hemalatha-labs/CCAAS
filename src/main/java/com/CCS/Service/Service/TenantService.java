package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.TenantRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TenantService {

	@Autowired
	private TenantRepo tenantRepo;
	
	public List<Tenant> getAllTenants(){
		return tenantRepo.findAll();	
	}
	public Optional<Tenant> gettenant(Long id){
		return tenantRepo.findById(id);
		
	}
	public Tenant newTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}
	
	public Tenant UpdateTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}
	
	public void deleteTenant(Long id) {
		tenantRepo.deleteById(id);
	}
	
	
	
	
}
