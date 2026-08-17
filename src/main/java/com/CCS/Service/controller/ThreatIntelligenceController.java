package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.ThreatIntelligenceRequestDTO;
import com.CCS.Service.ResponseDTO.ThreatIntelligenceResponseDTO;
import com.CCS.Service.Service.ThreatIntelligenceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/threat-intelligence")
@RequiredArgsConstructor
public class ThreatIntelligenceController {

    @Autowired
    private ThreatIntelligenceService threatIntelligenceService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ThreatIntelligenceResponseDTO>>>
    getAllThreats() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Threat intelligence fetched successfully",
                        threatIntelligenceService.getAllThreats(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ThreatIntelligenceResponseDTO>>
    getThreat(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Threat intelligence fetched successfully",
                        threatIntelligenceService.getThreat(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ThreatIntelligenceResponseDTO>>
    newThreat(
            @Valid @RequestBody
            ThreatIntelligenceRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Threat intelligence created successfully",
                        threatIntelligenceService.newThreat(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ThreatIntelligenceResponseDTO>>
    updateThreat(
            @PathVariable UUID id,
            @Valid @RequestBody
            ThreatIntelligenceRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Threat intelligence updated successfully",
                        threatIntelligenceService.updateThreat(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteThreat(@PathVariable UUID id) {

        threatIntelligenceService.deleteThreat(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Threat intelligence deleted successfully",
                        null,
                        true));
    }
}