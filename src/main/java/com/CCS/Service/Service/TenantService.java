package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.TenantMapper;
import com.CCS.Service.Repo.TenantRepo;
import com.CCS.Service.RequestDTO.TenantRequestDTO;
import com.CCS.Service.ResponseDTO.TenantResponseDTO;
import com.CCS.Service.model.Tenant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepo tenantRepo;
    private final TenantMapper tenantMapper;

    public List<TenantResponseDTO> getAllTenants() {

        return tenantRepo.findAll()
                .stream()
                .map(tenantMapper::toResponseDTO)
                .toList();
    }

    public TenantResponseDTO getTenant(UUID id) {

        Tenant tenant = tenantRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Tenant not found with id: " + id));

        return tenantMapper.toResponseDTO(tenant);
    }

    public TenantResponseDTO newTenant(
            TenantRequestDTO dto) {

        Tenant tenant = tenantMapper.toEntityTenant(dto);

        Tenant savedTenant = tenantRepo.save(tenant);
        

        return tenantMapper.toResponseDTO(savedTenant);
    }

    public TenantResponseDTO updateTenant(
            UUID id,
            TenantRequestDTO dto) {

        Tenant existingTenant = tenantRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Tenant not found with id: " + id));

        existingTenant.setTenantName(dto.getTenantName());
        existingTenant.setIndustry(dto.getIndustry());
        existingTenant.setSubscriptionPlan(
                dto.getSubscriptionPlan());
        existingTenant.setStatus(dto.getStatus());
        
        

        Tenant updatedTenant =
                tenantRepo.save(existingTenant);

        return tenantMapper.toResponseDTO(updatedTenant);
    }

    public void deleteTenant(UUID id) {

        if (!tenantRepo.existsById(id)) {
            throw new RuntimeException(
                "Tenant not found with id: " + id);
        }

        tenantRepo.deleteById(id);
    }
}