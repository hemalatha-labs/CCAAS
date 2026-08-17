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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.ComplianceScanRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceScanResponseDTO;
import com.CCS.Service.Service.ComplianceScanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-scans")
@RequiredArgsConstructor
public class ComplianceScanController {

    @Autowired
    private ComplianceScanService complianceScanService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ComplianceScanResponseDTO>>>
    getAllComplianceScans() {

        List<ComplianceScanResponseDTO> scans =
                complianceScanService
                        .getAllComplianceScans();

        ApiResponse<List<ComplianceScanResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance scans fetched successfully",
                        scans,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceScanResponseDTO>>
    getComplianceScan(
            @PathVariable UUID id) {

        ComplianceScanResponseDTO scan =
                complianceScanService
                        .getComplianceScan(id);

        ApiResponse<ComplianceScanResponseDTO> response =
                new ApiResponse<>(
                        "Compliance scan fetched successfully",
                        scan,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY SCHEDULE
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<
            ApiResponse<List<ComplianceScanResponseDTO>>>
    getScansBySchedule(
            @PathVariable UUID scheduleId) {

        List<ComplianceScanResponseDTO> scans =
                complianceScanService
                        .getScansBySchedule(
                                scheduleId);

        ApiResponse<List<ComplianceScanResponseDTO>> response =
                new ApiResponse<>(
                        "Compliance scans fetched successfully",
                        scans,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE / START SCAN
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ComplianceScanResponseDTO>>
    newComplianceScan(
            @Valid @RequestBody
            ComplianceScanRequestDTO dto) {

        ComplianceScanResponseDTO scan =
                complianceScanService
                        .newComplianceScan(dto);

        ApiResponse<ComplianceScanResponseDTO> response =
                new ApiResponse<>(
                        "Compliance scan started successfully",
                        scan,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteComplianceScan(
            @PathVariable UUID id) {

        complianceScanService
                .deleteComplianceScan(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Compliance scan deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}