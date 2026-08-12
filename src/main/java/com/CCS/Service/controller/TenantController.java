package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;
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
import com.CCS.Service.Service.TenantService;
import com.CCS.Service.model.Tenant;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Tenant>>> getAllTenants() {

        List<Tenant> tenants = tenantService.getAllTenants();

        return ResponseEntity.ok(
                new ApiResponse<>("Tenants fetched successfully", tenants, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Tenant>>> getTenantById(@PathVariable UUID id) {

        Optional<Tenant> tenant = tenantService.gettenant(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Tenant fetched successfully", tenant, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Tenant>> createTenant(@RequestBody Tenant tenant) {

        Tenant createdTenant = tenantService.newTenant(tenant);

        return ResponseEntity.ok(
                new ApiResponse<>("Tenant created successfully", createdTenant, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Tenant>> updateTenant(
            @PathVariable Long id,
            @RequestBody Tenant tenant) {

        Tenant updatedTenant = tenantService.UpdateTenant(tenant);

        return ResponseEntity.ok(
                new ApiResponse<>("Tenant updated successfully", updatedTenant, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTenant(@PathVariable UUID id) {

        tenantService.deleteTenant(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Tenant deleted successfully", null, true));
    }
}