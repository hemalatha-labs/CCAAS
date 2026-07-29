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
import com.CCS.Service.Service.ViolationService;
import com.CCS.Service.model.Violation;

@RestController
@RequestMapping("/api/violation")
public class ViolationController {

    @Autowired
    private ViolationService violationService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Violation>>> getAllViolations() {

        List<Violation> violations = violationService.getAllViolations();

        return ResponseEntity.ok(
                new ApiResponse<>("Violations fetched successfully", violations, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Violation>>> getViolationById(@PathVariable Long id) {

        Optional<Violation> violation = violationService.getViolation(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Violation fetched successfully", violation, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Violation>> createViolation(
            @RequestBody Violation violation) {

        Violation createdViolation = violationService.newViolation(violation);

        return ResponseEntity.ok(
                new ApiResponse<>("Violation created successfully", createdViolation, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Violation>> updateViolation(
            @PathVariable Long id,
            @RequestBody Violation violation) {

        Violation updatedViolation = violationService.UpdateViolation(violation);

        return ResponseEntity.ok(
                new ApiResponse<>("Violation updated successfully", updatedViolation, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteViolation(@PathVariable Long id) {

        violationService.deleteViolation(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Violation deleted successfully", null, true));
    }
}