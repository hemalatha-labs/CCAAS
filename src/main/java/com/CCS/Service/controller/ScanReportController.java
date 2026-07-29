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
import com.CCS.Service.Service.ScanReportService;
import com.CCS.Service.model.ScanReport;

@RestController
@RequestMapping("/api/scanreport")
public class ScanReportController {

    @Autowired
    private ScanReportService scanReportService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ScanReport>>> getAllScanReports() {

        List<ScanReport> scanReports = scanReportService.getAllScanReports();

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Reports fetched successfully", scanReports, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ScanReport>>> getScanReportById(@PathVariable Long id) {

        Optional<ScanReport> scanReport = scanReportService.getScanReport(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Report fetched successfully", scanReport, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ScanReport>> createScanReport(
            @RequestBody ScanReport scanReport) {

        ScanReport createdScanReport = scanReportService.newScanReport(scanReport);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Report created successfully", createdScanReport, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ScanReport>> updateScanReport(
            @PathVariable Long id,
            @RequestBody ScanReport scanReport) {

        ScanReport updatedScanReport =
                scanReportService.UpdateScanReport(scanReport);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Report updated successfully", updatedScanReport, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteScanReport(@PathVariable Long id) {

        scanReportService.deleteScanReport(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Report deleted successfully", null, true));
    }
}