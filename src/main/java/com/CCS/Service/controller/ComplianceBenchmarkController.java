package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.ComplianceBenchmarkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceBenchmarkResponseDTO;
import com.CCS.Service.Service.ComplianceBenchmarkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-benchmarks")
@RequiredArgsConstructor
public class ComplianceBenchmarkController {

    @Autowired
    private ComplianceBenchmarkService complianceBenchmarkService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ComplianceBenchmarkResponseDTO>>>
    getAllBenchmarks() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance benchmarks fetched successfully",
                        complianceBenchmarkService.getAllBenchmarks(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceBenchmarkResponseDTO>>
    getBenchmark(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance benchmark fetched successfully",
                        complianceBenchmarkService.getBenchmark(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ComplianceBenchmarkResponseDTO>>
    newBenchmark(
            @Valid @RequestBody
            ComplianceBenchmarkRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Compliance benchmark created successfully",
                        complianceBenchmarkService.newBenchmark(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceBenchmarkResponseDTO>>
    updateBenchmark(
            @PathVariable UUID id,
            @Valid @RequestBody
            ComplianceBenchmarkRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance benchmark updated successfully",
                        complianceBenchmarkService
                                .updateBenchmark(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteBenchmark(@PathVariable UUID id) {

        complianceBenchmarkService.deleteBenchmark(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance benchmark deleted successfully",
                        null,
                        true));
    }
}