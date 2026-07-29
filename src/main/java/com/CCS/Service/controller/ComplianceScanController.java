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
import com.CCS.Service.Service.ComplianceScanService;
import com.CCS.Service.model.ComplianceScan;

@RestController
@RequestMapping("/api/compliancescan")
public class ComplianceScanController {

    @Autowired
    private ComplianceScanService complianceScanService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ComplianceScan>>> getAllComplianceScans() {

        List<ComplianceScan> complianceScans = complianceScanService.getAllComplianceScans();

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Scans fetched successfully", complianceScans, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ComplianceScan>>> getComplianceScanById(@PathVariable Long id) {

        Optional<ComplianceScan> complianceScan = complianceScanService.getComplianceScan(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Scan fetched successfully", complianceScan, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ComplianceScan>> createComplianceScan(
            @RequestBody ComplianceScan complianceScan) {

        ComplianceScan createdComplianceScan =
                complianceScanService.newComplianceScan(complianceScan);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Scan created successfully", createdComplianceScan, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComplianceScan>> updateComplianceScan(
            @PathVariable Long id,
            @RequestBody ComplianceScan complianceScan) {

        ComplianceScan updatedComplianceScan =
                complianceScanService.UpdateComplianceScan(complianceScan);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Scan updated successfully", updatedComplianceScan, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComplianceScan(@PathVariable Long id) {

        complianceScanService.deleteComplianceScan(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Scan deleted successfully", null, true));
    }
}