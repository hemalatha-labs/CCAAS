package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.TenantRequestDTO;

@Component
public class tenantValidation {
	public void validateTenant(TenantRequestDTO dto) {

	        if (dto == null) {
	            throw new IllegalArgumentException("Tenant data cannot be null");
	        }

	        if (dto.getTenantName() == null || dto.getTenantName().isBlank()) {
	            throw new IllegalArgumentException("Tenant name cannot be empty");
	        }

	        if (dto.getIndustry() == null) {
	            throw new IllegalArgumentException("Industry is required");
	        }

	        if (dto.getSubscriptionPlan() == null) {
	            throw new IllegalArgumentException("Subscription plan is required");
	        }

	        if (dto.getStatus() == null) {
	            throw new IllegalArgumentException("Tenant status is required");
	        }
	    }
}