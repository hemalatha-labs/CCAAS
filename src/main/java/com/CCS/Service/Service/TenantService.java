package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.TenantMapper;
import com.CCS.Service.Repo.TenantRepo;
import com.CCS.Service.RequestDTO.TenantRequestDTO;
import com.CCS.Service.ResponseDTO.TenantResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Tenant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantService {

    @Autowired
    private TenantRepo tenantRepo;

    @Autowired
    private TenantMapper tenantMapper;


    // GET ALL
    public List<TenantResponseDTO> getAllTenants() {

        return tenantRepo.findAll()
                .stream()
                .map(tenantMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public TenantResponseDTO getTenant(UUID id) {

        Tenant tenant = tenantRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tenant not found with id: " + id));

        return tenantMapper.toResponseDTO(tenant);
    }


    // CREATE
    public TenantResponseDTO newTenant(
            TenantRequestDTO dto) {

        Tenant tenant = tenantMapper.toEntity(dto);

        return tenantMapper.toResponseDTO(
                tenantRepo.save(tenant));
    }


    // UPDATE
    public TenantResponseDTO updateTenant(
            UUID id,
            TenantRequestDTO dto) {

        Tenant existingTenant = tenantRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tenant not found with id: " + id));

        if (dto.getTenantName() != null) {
            existingTenant.setTenantName(
                    dto.getTenantName());
        }

        if (dto.getIndustry() != null) {
            existingTenant.setIndustry(
                    dto.getIndustry());
        }

        if (dto.getSubscriptionPlan() != null) {
            existingTenant.setSubscriptionPlan(
                    dto.getSubscriptionPlan());
        }

        if (dto.getStatus() != null) {
            existingTenant.setStatus(
                    dto.getStatus());
        }

        return tenantMapper.toResponseDTO(
                tenantRepo.save(existingTenant));
    }


    // DELETE
    public void deleteTenant(UUID id) {

        Tenant tenant = tenantRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tenant not found with id: " + id));

        tenantRepo.delete(tenant);
    }
}