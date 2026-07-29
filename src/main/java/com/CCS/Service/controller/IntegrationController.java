package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;

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
import com.CCS.Service.Service.IntegrationService;
import com.CCS.Service.model.Integration;

@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

    @Autowired
    private IntegrationService integrationService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Integration>>> getAllIntegrations() {

        List<Integration> integrations = integrationService.getAllIntegrations();

        return ResponseEntity.ok(
                new ApiResponse<>("Integrations fetched successfully", integrations, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Integration>>> getIntegrationById(@PathVariable Long id) {

        Optional<Integration> integration = integrationService.getIntegration(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Integration fetched successfully", integration, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Integration>> createIntegration(@RequestBody Integration integration) {

        Integration createdIntegration = integrationService.newIntegration(integration);

        return ResponseEntity.ok(
                new ApiResponse<>("Integration created successfully", createdIntegration, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Integration>> updateIntegration(
            @PathVariable Long id,
            @RequestBody Integration integration) {

        Integration updatedIntegration = integrationService.UpdateIntegration(integration);

        return ResponseEntity.ok(
                new ApiResponse<>("Integration updated successfully", updatedIntegration, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteIntegration(@PathVariable Long id) {

        integrationService.deleteIntegration(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Integration deleted successfully", null, true));
    }
}