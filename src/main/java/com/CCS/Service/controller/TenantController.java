package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.ResponseDTO.TenantResponseDTO;
import com.CCS.Service.Service.TenantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<TenantResponseDTO>>> getAllTenants() {

        List<TenantResponseDTO> tenants =
                tenantService.getAllTenants();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenants fetched successfully",
                        tenants,
                        true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TenantResponseDTO>> getTenantById(
            @PathVariable UUID id) {

        TenantResponseDTO tenant =
                tenantService.getTenant(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant fetched successfully",
                        tenant,
                        true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TenantResponseDTO>> createTenant(
            @Valid @RequestBody com.CCS.Service.RequestDTO.TenantRequestDTO dto) {

        TenantResponseDTO createdTenant =
                tenantService.newTenant(dto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant created successfully",
                        createdTenant,
                        true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TenantResponseDTO>> updateTenant(
            @PathVariable UUID id,
            @Valid @RequestBody com.CCS.Service.RequestDTO.TenantRequestDTO dto) {

        TenantResponseDTO updatedTenant =
                tenantService.updateTenant(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant updated successfully",
                        updatedTenant,
                        true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTenant(
            @PathVariable UUID id) {

        tenantService.deleteTenant(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant deleted successfully",
                        null,
                        true));
    }
}