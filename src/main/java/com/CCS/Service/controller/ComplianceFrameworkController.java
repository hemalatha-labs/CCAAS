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
import com.CCS.Service.RequestDTO.ComplianceFrameworkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceFrameworkResponseDTO;
import com.CCS.Service.Service.ComplianceFrameworkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-frameworks")
@RequiredArgsConstructor
public class ComplianceFrameworkController {

    @Autowired
    private ComplianceFrameworkService complianceFrameworkService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ComplianceFrameworkResponseDTO>>>
    getAllComplianceFrameworks() {

        List<ComplianceFrameworkResponseDTO> frameworks =
                complianceFrameworkService
                        .getAllComplianceFrameworks();

        ApiResponse<List<ComplianceFrameworkResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance frameworks fetched successfully",
                        frameworks,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceFrameworkResponseDTO>>
    getComplianceFramework(
            @PathVariable UUID id) {

        ComplianceFrameworkResponseDTO framework =
                complianceFrameworkService
                        .getComplianceFramework(id);

        ApiResponse<ComplianceFrameworkResponseDTO> response =
                new ApiResponse<>(
                        "Compliance framework fetched successfully",
                        framework,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ComplianceFrameworkResponseDTO>>
    newComplianceFramework(
            @Valid @RequestBody
            ComplianceFrameworkRequestDTO dto) {

        ComplianceFrameworkResponseDTO framework =
                complianceFrameworkService
                        .newComplianceFramework(dto);

        ApiResponse<ComplianceFrameworkResponseDTO> response =
                new ApiResponse<>(
                        "Compliance framework created successfully",
                        framework,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceFrameworkResponseDTO>>
    updateComplianceFramework(
            @PathVariable UUID id,
            @Valid @RequestBody
            ComplianceFrameworkRequestDTO dto) {

        ComplianceFrameworkResponseDTO framework =
                complianceFrameworkService
                        .updateComplianceFramework(id, dto);

        ApiResponse<ComplianceFrameworkResponseDTO> response =
                new ApiResponse<>(
                        "Compliance framework updated successfully",
                        framework,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteComplianceFramework(
            @PathVariable UUID id) {

        complianceFrameworkService
                .deleteComplianceFramework(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Compliance framework deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}