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
import com.CCS.Service.Enumuration.ViolationStatus;
import com.CCS.Service.RequestDTO.ViolationRequestDTO;
import com.CCS.Service.ResponseDTO.ViolationResponseDTO;
import com.CCS.Service.Service.ViolationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/violations")
@RequiredArgsConstructor
public class ViolationController {

    @Autowired
    private ViolationService violationService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ViolationResponseDTO>>>
    getAllViolations() {

        List<ViolationResponseDTO> violations =
                violationService
                        .getAllViolations();

        ApiResponse<List<ViolationResponseDTO>> response =
                new ApiResponse<>(
                        "Violations fetched successfully",
                        violations,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ViolationResponseDTO>>
    getViolation(
            @PathVariable UUID id) {

        ViolationResponseDTO violation =
                violationService
                        .getViolation(id);

        ApiResponse<ViolationResponseDTO> response =
                new ApiResponse<>(
                        "Violation fetched successfully",
                        violation,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY SCAN
    @GetMapping("/scan/{scanId}")
    public ResponseEntity<
            ApiResponse<List<ViolationResponseDTO>>>
    getViolationsByScan(
            @PathVariable UUID scanId) {

        List<ViolationResponseDTO> violations =
                violationService
                        .getViolationsByScan(
                                scanId);

        ApiResponse<List<ViolationResponseDTO>> response =
                new ApiResponse<>(
                        "Violations fetched successfully",
                        violations,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ViolationResponseDTO>>
    newViolation(
            @Valid @RequestBody
            ViolationRequestDTO dto) {

        ViolationResponseDTO violation =
                violationService
                        .newViolation(dto);

        ApiResponse<ViolationResponseDTO> response =
                new ApiResponse<>(
                        "Violation created successfully",
                        violation,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE STATUS
    @PutMapping("/{id}/status")
    public ResponseEntity<
            ApiResponse<ViolationResponseDTO>>
    updateViolationStatus(
            @PathVariable UUID id,
            @RequestBody ViolationStatus status) {

        ViolationResponseDTO violation =
                violationService
                        .updateViolationStatus(
                                id, status);

        ApiResponse<ViolationResponseDTO> response =
                new ApiResponse<>(
                        "Violation status updated successfully",
                        violation,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteViolation(
            @PathVariable UUID id) {

        violationService
                .deleteViolation(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Violation deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}