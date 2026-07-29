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
import com.CCS.Service.Service.CompliancePolicyService;
import com.CCS.Service.model.CompliancePolicy;

@RestController
@RequestMapping("/api/compliancepolicy")
public class CompliancePolicyController {

    @Autowired
    private CompliancePolicyService compliancePolicyService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CompliancePolicy>>> getAllCompliancePolicies() {

        List<CompliancePolicy> policies = compliancePolicyService.getAllCompliancePolicies();

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Policies fetched successfully", policies, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<CompliancePolicy>>> getCompliancePolicyById(@PathVariable Long id) {

        Optional<CompliancePolicy> policy = compliancePolicyService.getCompliancePolicy(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Policy fetched successfully", policy, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CompliancePolicy>> createCompliancePolicy(
            @RequestBody CompliancePolicy policy) {

        CompliancePolicy createdPolicy = compliancePolicyService.newCompliancePolicy(policy);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Policy created successfully", createdPolicy, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CompliancePolicy>> updateCompliancePolicy(
            @PathVariable Long id,
            @RequestBody CompliancePolicy policy) {

        CompliancePolicy updatedPolicy =
                compliancePolicyService.UpdateCompliancePolicy(policy);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Policy updated successfully", updatedPolicy, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCompliancePolicy(@PathVariable Long id) {

        compliancePolicyService.deleteCompliancePolicy(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Policy deleted successfully", null, true));
    }
}