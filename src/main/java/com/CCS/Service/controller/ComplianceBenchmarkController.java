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
import com.CCS.Service.Service.ComplianceBenchmarkService;
import com.CCS.Service.model.ComplianceBenchmark;

@RestController
@RequestMapping("/api/compliancebenchmark")
public class ComplianceBenchmarkController {

    @Autowired
    private ComplianceBenchmarkService complianceBenchmarkService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ComplianceBenchmark>>> getAllComplianceBenchmarks() {

        List<ComplianceBenchmark> benchmarks =
                complianceBenchmarkService.getAllComplianceBenchmarks();

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Benchmarks fetched successfully",
                        benchmarks, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<ComplianceBenchmark>>> getComplianceBenchmarkById(
            @PathVariable Long id) {

        Optional<ComplianceBenchmark> benchmark =
                complianceBenchmarkService.getComplianceBenchmark(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Benchmark fetched successfully",
                        benchmark, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ComplianceBenchmark>> createComplianceBenchmark(
            @RequestBody ComplianceBenchmark benchmark) {

        ComplianceBenchmark createdBenchmark =
                complianceBenchmarkService.newComplianceBenchmark(benchmark);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Benchmark created successfully",
                        createdBenchmark, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComplianceBenchmark>> updateComplianceBenchmark(
            @PathVariable Long id,
            @RequestBody ComplianceBenchmark benchmark) {

        ComplianceBenchmark updatedBenchmark =
                complianceBenchmarkService.UpdateComplianceBenchmark(benchmark);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Benchmark updated successfully",
                        updatedBenchmark, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComplianceBenchmark(
            @PathVariable Long id) {

        complianceBenchmarkService.deleteComplianceBenchmark(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Compliance Benchmark deleted successfully",
                        null, true));
    }
}