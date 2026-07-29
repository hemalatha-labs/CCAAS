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
import com.CCS.Service.Service.ScanScheduleService;
import com.CCS.Service.model.ScanSchedule;

@RestController
@RequestMapping("/api/scanschedule")
public class ScanScheduleController {

    @Autowired
    private ScanScheduleService scanScheduleService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ScanSchedule>>> getAllScanSchedules() {

        List<ScanSchedule> scanSchedules = scanScheduleService.getAllScanSchedules();

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Schedules fetched successfully", scanSchedules, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ScanSchedule>>> getScanScheduleById(@PathVariable Long id) {

        Optional<ScanSchedule> scanSchedule = scanScheduleService.getScanSchedule(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Schedule fetched successfully", scanSchedule, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ScanSchedule>> createScanSchedule(
            @RequestBody ScanSchedule scanSchedule) {

        ScanSchedule createdScanSchedule = scanScheduleService.newScanSchedule(scanSchedule);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Schedule created successfully", createdScanSchedule, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ScanSchedule>> updateScanSchedule(
            @PathVariable Long id,
            @RequestBody ScanSchedule scanSchedule) {

        ScanSchedule updatedScanSchedule =
                scanScheduleService.UpdateScanSchedule(scanSchedule);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Schedule updated successfully", updatedScanSchedule, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteScanSchedule(@PathVariable Long id) {

        scanScheduleService.deleteScanSchedule(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Scan Schedule deleted successfully", null, true));
    }
}