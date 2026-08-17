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
import com.CCS.Service.RequestDTO.ComplianceRuleRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceRuleResponseDTO;
import com.CCS.Service.Service.ComplianceRuleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-rules")
@RequiredArgsConstructor
public class ComplianceRuleController {

    @Autowired
    private ComplianceRuleService complianceRuleService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ComplianceRuleResponseDTO>>>
    getAllComplianceRules() {

        List<ComplianceRuleResponseDTO> rules =
                complianceRuleService
                        .getAllComplianceRules();

        ApiResponse<List<ComplianceRuleResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance rules fetched successfully",
                        rules,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceRuleResponseDTO>>
    getComplianceRule(
            @PathVariable UUID id) {

        ComplianceRuleResponseDTO rule =
                complianceRuleService
                        .getComplianceRule(id);

        ApiResponse<ComplianceRuleResponseDTO> response =
                new ApiResponse<>(
                        "Compliance rule fetched successfully",
                        rule,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY POLICY
    @GetMapping("/policy/{policyId}")
    public ResponseEntity<
            ApiResponse<List<ComplianceRuleResponseDTO>>>
    getRulesByPolicy(
            @PathVariable UUID policyId) {

        List<ComplianceRuleResponseDTO> rules =
                complianceRuleService
                        .getRulesByPolicy(policyId);

        ApiResponse<List<ComplianceRuleResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance rules fetched successfully",
                        rules,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ComplianceRuleResponseDTO>>
    newComplianceRule(
            @Valid @RequestBody
            ComplianceRuleRequestDTO dto) {

        ComplianceRuleResponseDTO rule =
                complianceRuleService
                        .newComplianceRule(dto);

        ApiResponse<ComplianceRuleResponseDTO> response =
                new ApiResponse<>(
                        "Compliance rule created successfully",
                        rule,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceRuleResponseDTO>>
    updateComplianceRule(
            @PathVariable UUID id,
            @Valid @RequestBody
            ComplianceRuleRequestDTO dto) {

        ComplianceRuleResponseDTO rule =
                complianceRuleService
                        .updateComplianceRule(
                                id, dto);

        ApiResponse<ComplianceRuleResponseDTO> response =
                new ApiResponse<>(
                        "Compliance rule updated successfully",
                        rule,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteComplianceRule(
            @PathVariable UUID id) {

        complianceRuleService
                .deleteComplianceRule(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Compliance rule deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}