package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.CCS.Service.RequestDTO.CompliancePolicyRequestDTO;
import com.CCS.Service.ResponseDTO.CompliancePolicyResponseDTO;
import com.CCS.Service.Service.CompliancePolicyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-policies")
@RequiredArgsConstructor
public class CompliancePolicyController {

    @Autowired
    private CompliancePolicyService compliancePolicyService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<CompliancePolicyResponseDTO>>>
    getAllCompliancePolicies() {

        List<CompliancePolicyResponseDTO> policies =
                compliancePolicyService
                        .getAllCompliancePolicies();

        ApiResponse<List<CompliancePolicyResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance policies fetched successfully",
                        policies,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<CompliancePolicyResponseDTO>>
    getCompliancePolicy(
            @PathVariable UUID id) {

        CompliancePolicyResponseDTO policy =
                compliancePolicyService
                        .getCompliancePolicy(id);

        ApiResponse<CompliancePolicyResponseDTO> response =
                new ApiResponse<>(
                        "Compliance policy fetched successfully",
                        policy,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY FRAMEWORK
    @GetMapping("/framework/{frameworkId}")
    public ResponseEntity<
            ApiResponse<List<CompliancePolicyResponseDTO>>>
    getPoliciesByFramework(
            @PathVariable UUID frameworkId) {

        List<CompliancePolicyResponseDTO> policies =
                compliancePolicyService
                        .getPoliciesByFramework(
                                frameworkId);

        ApiResponse<List<CompliancePolicyResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance policies fetched successfully",
                        policies,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<CompliancePolicyResponseDTO>>
    newCompliancePolicy(
            @Valid @RequestBody
            CompliancePolicyRequestDTO dto) {

        CompliancePolicyResponseDTO policy =
                compliancePolicyService
                        .newCompliancePolicy(dto);

        ApiResponse<CompliancePolicyResponseDTO> response =
                new ApiResponse<>(
                        "Compliance policy created successfully",
                        policy,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<CompliancePolicyResponseDTO>>
    updateCompliancePolicy(
            @PathVariable UUID id,
            @Valid @RequestBody
            CompliancePolicyRequestDTO dto) {

        CompliancePolicyResponseDTO policy =
                compliancePolicyService
                        .updateCompliancePolicy(
                                id, dto);

        ApiResponse<CompliancePolicyResponseDTO> response =
                new ApiResponse<>(
                        "Compliance policy updated successfully",
                        policy,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteCompliancePolicy(
            @PathVariable UUID id) {

        compliancePolicyService
                .deleteCompliancePolicy(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Compliance policy deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}