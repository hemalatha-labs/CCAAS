package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.TenantRequestDTO;
import com.CCS.Service.ResponseDTO.TenantResponseDTO;
import com.CCS.Service.Service.TenantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    @Autowired
    private TenantService tenantService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<TenantResponseDTO>>>
    getAllTenants() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenants fetched successfully",
                        tenantService.getAllTenants(),
                        true));
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<TenantResponseDTO>>
    getTenant(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant fetched successfully",
                        tenantService.getTenant(id),
                        true));
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<TenantResponseDTO>>
    newTenant(
            @Valid @RequestBody
            TenantRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Tenant created successfully",
                        tenantService.newTenant(dto),
                        true),
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<TenantResponseDTO>>
    updateTenant(
            @PathVariable UUID id,
            @Valid @RequestBody
            TenantRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant updated successfully",
                        tenantService.updateTenant(id, dto),
                        true));
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteTenant(@PathVariable UUID id) {

        tenantService.deleteTenant(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Tenant deleted successfully",
                        null,
                        true));
    }
}