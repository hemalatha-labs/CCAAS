package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.ResponseDTO.TenantResponseDTO;
import com.CCS.Service.RequestDTO.TenantRequestDTO;
import com.CCS.Service.model.Tenant;

@Component
public class TenantMapper {
	
	    public Tenant toEntityTenant(TenantRequestDTO dto) {

	        Tenant tenant = new Tenant();
	        tenant.setTenantName(dto.getTenantName());
	        tenant.setIndustry(dto.getIndustry());
	        tenant.setSubscriptionPlan(
	                dto.getSubscriptionPlan());
	        tenant.setStatus(dto.getStatus());
	        tenant.setCreatedAT(LocalDateTime.now());
	        return tenant;
	    }

	    public TenantResponseDTO toResponseDTO(Tenant tenant) {

	        TenantResponseDTO dto =
	                new TenantResponseDTO();

	        dto.setTenantId(tenant.getTenantId());
	        dto.setTenantName(tenant.getTenantName());
	        dto.setIndustry(tenant.getIndustry());
	        dto.setSubscriptionPlan(tenant.getSubscriptionPlan());
	        dto.setStatus(tenant.getStatus());
	        dto.setCreatedAt(tenant.getCreatedAT());

	        return dto;
	    
	}
}
