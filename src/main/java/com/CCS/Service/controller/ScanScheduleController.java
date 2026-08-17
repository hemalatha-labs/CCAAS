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
import com.CCS.Service.RequestDTO.ScanScheduleRequestDTO;
import com.CCS.Service.ResponseDTO.ScanScheduleResponseDTO;
import com.CCS.Service.Service.ScanScheduleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scan-schedules")
@RequiredArgsConstructor
public class ScanScheduleController {

    @Autowired
    private ScanScheduleService scanScheduleService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ScanScheduleResponseDTO>>>
    getAllScanSchedules() {

        List<ScanScheduleResponseDTO> schedules =
                scanScheduleService
                        .getAllScanSchedules();

        ApiResponse<List<ScanScheduleResponseDTO>> response =
                new ApiResponse<>(
                        "Scan schedules fetched successfully",
                        schedules,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ScanScheduleResponseDTO>>
    getScanSchedule(
            @PathVariable UUID id) {

        ScanScheduleResponseDTO schedule =
                scanScheduleService
                        .getScanSchedule(id);

        ApiResponse<ScanScheduleResponseDTO> response =
                new ApiResponse<>(
                        "Scan schedule fetched successfully",
                        schedule,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY CLOUD ACCOUNT
    @GetMapping("/cloud-account/{cloudAccountId}")
    public ResponseEntity<
            ApiResponse<List<ScanScheduleResponseDTO>>>
    getSchedulesByCloudAccount(
            @PathVariable UUID cloudAccountId) {

        List<ScanScheduleResponseDTO> schedules =
                scanScheduleService
                        .getSchedulesByCloudAccount(
                                cloudAccountId);

        ApiResponse<List<ScanScheduleResponseDTO>> response =
                new ApiResponse<>(
                        "Scan schedules fetched successfully",
                        schedules,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ScanScheduleResponseDTO>>
    newScanSchedule(
            @Valid @RequestBody
            ScanScheduleRequestDTO dto) {

        ScanScheduleResponseDTO schedule =
                scanScheduleService
                        .newScanSchedule(dto);

        ApiResponse<ScanScheduleResponseDTO> response =
                new ApiResponse<>(
                        "Scan schedule created successfully",
                        schedule,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<ScanScheduleResponseDTO>>
    updateScanSchedule(
            @PathVariable UUID id,
            @Valid @RequestBody
            ScanScheduleRequestDTO dto) {

        ScanScheduleResponseDTO schedule =
                scanScheduleService
                        .updateScanSchedule(id, dto);

        ApiResponse<ScanScheduleResponseDTO> response =
                new ApiResponse<>(
                        "Scan schedule updated successfully",
                        schedule,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteScanSchedule(
            @PathVariable UUID id) {

        scanScheduleService
                .deleteScanSchedule(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Scan schedule deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}